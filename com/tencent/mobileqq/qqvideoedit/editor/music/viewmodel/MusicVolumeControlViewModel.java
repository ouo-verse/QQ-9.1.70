package com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 <2\u00020\u0001:\u0002=>B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0013R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u0013R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00158\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\u001dR\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\u0013R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010\u0013R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00158\u0006\u00a2\u0006\f\n\u0004\b5\u0010\u0017\u001a\u0004\b6\u0010\u0019R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010$\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel;", "Landroidx/lifecycle/ViewModel;", "", "value", "Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "sliderType", "", "P1", "R1", "type", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "enable", "b2", "c2", "isUseTemplate", "W1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_curOperateBgmType", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "getCurOperateBgmType", "()Landroidx/lifecycle/LiveData;", "curOperateBgmType", "Landroidx/lifecycle/MediatorLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MediatorLiveData;", "_originLiveData", "D", "T1", "originLiveData", "E", "_originSliderLiveData", UserInfo.SEX_FEMALE, "U1", "originSliderLiveData", "G", "_originEnabledLiveData", "H", "S1", "originEnabledLiveData", "I", "_bgmLiveData", "J", "Q1", "bgmLiveData", "K", "_bgmSliderLiveData", "L", "_originVolumeSwitchLiveData", "M", "getOriginVolumeSwitchLiveData", "originVolumeSwitchLiveData", "N", "lastOriginVolume", "<init>", "()V", "P", "a", "VolumeType", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class MusicVolumeControlViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Float> _originLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Float> originLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Float> _originSliderLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Float> originSliderLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _originEnabledLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> originEnabledLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Float> _bgmLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Float> bgmLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Float> _bgmSliderLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _originVolumeSwitchLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> originVolumeSwitchLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    private float lastOriginVolume;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<VolumeType> _curOperateBgmType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<VolumeType> curOperateBgmType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "", "(Ljava/lang/String;I)V", "ORIGIN", "BGM", "TEMPLATE", "NONE", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public enum VolumeType {
        ORIGIN,
        BGM,
        TEMPLATE,
        NONE
    }

    public MusicVolumeControlViewModel() {
        MutableLiveData<VolumeType> mutableLiveData = new MutableLiveData<>(VolumeType.NONE);
        this._curOperateBgmType = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.MusicVolumeControlViewModel.VolumeType>");
        this.curOperateBgmType = mutableLiveData;
        MediatorLiveData<Float> mediatorLiveData = new MediatorLiveData<>();
        this._originLiveData = mediatorLiveData;
        Intrinsics.checkNotNull(mediatorLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Float>");
        this.originLiveData = mediatorLiveData;
        MutableLiveData<Float> mutableLiveData2 = new MutableLiveData<>();
        this._originSliderLiveData = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Float>");
        this.originSliderLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._originEnabledLiveData = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.originEnabledLiveData = mutableLiveData3;
        MediatorLiveData<Float> mediatorLiveData2 = new MediatorLiveData<>();
        this._bgmLiveData = mediatorLiveData2;
        Intrinsics.checkNotNull(mediatorLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Float>");
        this.bgmLiveData = mediatorLiveData2;
        this._bgmSliderLiveData = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._originVolumeSwitchLiveData = mutableLiveData4;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.originVolumeSwitchLiveData = mutableLiveData4;
        final MusicVolumeControlViewModel$1$1 musicVolumeControlViewModel$1$1 = new MusicVolumeControlViewModel$1$1(mediatorLiveData, this);
        mediatorLiveData.addSource(mutableLiveData3, new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlViewModel.X1(Function1.this, obj);
            }
        });
        final MusicVolumeControlViewModel$2$1 musicVolumeControlViewModel$2$1 = new MusicVolumeControlViewModel$2$1(mediatorLiveData2, this);
        mediatorLiveData2.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlViewModel.Z1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void P1(float value, @NotNull VolumeType sliderType) {
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        if (sliderType == VolumeType.ORIGIN) {
            this._originSliderLiveData.postValue(Float.valueOf(value));
        } else {
            this._bgmSliderLiveData.postValue(Float.valueOf(value));
        }
    }

    @NotNull
    public final LiveData<Float> Q1() {
        return this.bgmLiveData;
    }

    @NotNull
    public final VolumeType R1() {
        VolumeType value = this._curOperateBgmType.getValue();
        if (value == null) {
            return VolumeType.NONE;
        }
        return value;
    }

    @NotNull
    public final LiveData<Boolean> S1() {
        return this.originEnabledLiveData;
    }

    @NotNull
    public final LiveData<Float> T1() {
        return this.originLiveData;
    }

    @NotNull
    public final LiveData<Float> U1() {
        return this.originSliderLiveData;
    }

    public final void W1(boolean enable, boolean isUseTemplate) {
        float floatValue;
        boolean z16;
        float f16;
        if (enable) {
            float f17 = this.lastOriginVolume;
            if (f17 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (isUseTemplate) {
                    f16 = 0.15f;
                } else {
                    f16 = 1.0f;
                }
                f17 = f16;
            }
            this.lastOriginVolume = f17;
            this._originSliderLiveData.postValue(Float.valueOf(f17));
        } else {
            Float value = this.originSliderLiveData.getValue();
            if (value == null) {
                floatValue = 0.0f;
            } else {
                floatValue = value.floatValue();
            }
            this.lastOriginVolume = floatValue;
            this._originSliderLiveData.postValue(Float.valueOf(0.0f));
        }
        c2(enable);
    }

    public final void a2(@NotNull VolumeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this._curOperateBgmType.getValue() != type) {
            this._curOperateBgmType.postValue(type);
        }
    }

    public final void b2(boolean enable) {
        if (!Intrinsics.areEqual(Boolean.valueOf(enable), this._originEnabledLiveData.getValue())) {
            this._originEnabledLiveData.postValue(Boolean.valueOf(enable));
        }
    }

    public final void c2(boolean enable) {
        if (!Intrinsics.areEqual(Boolean.valueOf(enable), this._originVolumeSwitchLiveData.getValue())) {
            this._originVolumeSwitchLiveData.postValue(Boolean.valueOf(enable));
        }
    }
}

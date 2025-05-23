package com.tencent.aelight.camera.ae.camera.aibeauty;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/aibeauty/d;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/aelight/camera/ae/camera/aibeauty/AIBeautyFaceType;", "type", "", "M1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "L1", "()Landroidx/lifecycle/MutableLiveData;", "aiBeautyFaceType", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<AIBeautyFaceType> aiBeautyFaceType = new MutableLiveData<>(AIBeautyFaceType.NO_FACE);

    public final MutableLiveData<AIBeautyFaceType> L1() {
        return this.aiBeautyFaceType;
    }

    public final void M1(AIBeautyFaceType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.aiBeautyFaceType.postValue(type);
    }
}

package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/aa;", "Landroidx/lifecycle/ViewModel;", "", "S1", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "T1", "Lcom/tencent/aelight/camera/ae/mode/AECaptureMode;", "mode", "R1", "", "L1", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "cosmeticList", "Q1", "O1", "dummyData", "P1", "i", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/mode/AECaptureMode;", AECameraConstants.KEY_CAPTURE_MODE, "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_cosmeticsLiveData", "D", "_selectedMaterial", "M1", "()Landroidx/lifecycle/MutableLiveData;", "cosmeticsLiveData", "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "selectedMaterial", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class aa extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<bj>> _cosmeticsLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<bj> _selectedMaterial = new MutableLiveData<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AEMaterialMetaData material;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private AECaptureMode captureMode;

    private final void S1() {
        boolean L1 = L1();
        List<bj> value = this._cosmeticsLiveData.getValue();
        if (value == null) {
            return;
        }
        Iterator<T> it = value.iterator();
        while (it.hasNext()) {
            ((bj) it.next()).n(L1);
        }
        this._cosmeticsLiveData.postValue(value);
        this._selectedMaterial.postValue(this._selectedMaterial.getValue());
    }

    public final boolean L1() {
        AEMaterialMetaData aEMaterialMetaData;
        return this.captureMode != AECaptureMode.GIF && ((aEMaterialMetaData = this.material) == null || AEMaterialMetaData.isNoneMaterial(aEMaterialMetaData));
    }

    public final MutableLiveData<List<bj>> M1() {
        return this._cosmeticsLiveData;
    }

    public final LiveData<bj> N1() {
        return this._selectedMaterial;
    }

    public final void O1() {
        bj value = this._selectedMaterial.getValue();
        if (value == null) {
            return;
        }
        this._selectedMaterial.postValue(value);
    }

    public final void P1(bj dummyData) {
        Intrinsics.checkNotNullParameter(dummyData, "dummyData");
        this._selectedMaterial.postValue(dummyData);
    }

    public final void Q1(List<? extends bj> cosmeticList) {
        Intrinsics.checkNotNullParameter(cosmeticList, "cosmeticList");
        boolean L1 = L1();
        Iterator<T> it = cosmeticList.iterator();
        while (it.hasNext()) {
            ((bj) it.next()).n(L1);
        }
        this._cosmeticsLiveData.postValue(cosmeticList);
    }

    public final void R1(AECaptureMode mode) {
        this.captureMode = mode;
        S1();
    }

    public final void T1(AEMaterialMetaData material) {
        this.material = material;
        S1();
    }
}

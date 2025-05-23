package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/t;", "Landroidx/lifecycle/ViewModel;", "", "M1", "L1", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "locateMaterial", "Q1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bv;", "i", "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "daoJuPanelShowLiveData", "", "P1", "()Z", "isDaoJuPanelShow", "O1", "hasBottomPanelShow", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class t extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<bv> daoJuPanelShowLiveData = new MutableLiveData<>();

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (r0.getShow() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void M1() {
        boolean z16;
        bv value = this.daoJuPanelShowLiveData.getValue();
        if (value != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            this.daoJuPanelShowLiveData.postValue(new bv(false, null, 2, null));
        }
    }

    public final void L1() {
        M1();
    }

    public final MutableLiveData<bv> N1() {
        return this.daoJuPanelShowLiveData;
    }

    public final boolean O1() {
        return P1();
    }

    public final boolean P1() {
        bv value = this.daoJuPanelShowLiveData.getValue();
        if (value != null) {
            return value.getShow();
        }
        return false;
    }

    public final void Q1(AEMaterialMetaData locateMaterial) {
        this.daoJuPanelShowLiveData.postValue(new bv(true, locateMaterial));
    }
}

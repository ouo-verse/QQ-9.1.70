package com.tencent.sqshow.zootopia.nativeui.ue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.nativeui.ue.u;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/ab;", "Lcom/tencent/sqshow/zootopia/nativeui/ue/u;", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "", "onFirstFrame", "", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "withToast", "Ga", "Landroidx/lifecycle/LiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "ueFirstFrameReady", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ab implements u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Boolean> ueFirstFrameReady;

    public ab() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.ueFirstFrameReady = mutableLiveData;
        mutableLiveData.setValue(Boolean.FALSE);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.u
    public boolean Ga(boolean withToast) {
        Boolean value = this.ueFirstFrameReady.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        if (withToast && !booleanValue) {
            QQToast.makeText(BaseApplication.context, 1, "\u6b63\u5728\u52a0\u8f7d\u89d2\u8272\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
        }
        return booleanValue;
    }

    public LiveData<Boolean> a() {
        return this.ueFirstFrameReady;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void engineInitFinish(boolean z16) {
        u.a.b(this, z16);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.ueFirstFrameReady.postValue(Boolean.TRUE);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void serviceConnected(boolean connect) {
        if (connect) {
            return;
        }
        this.ueFirstFrameReady.postValue(Boolean.FALSE);
    }
}

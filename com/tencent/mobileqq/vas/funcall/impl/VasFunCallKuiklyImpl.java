package com.tencent.mobileqq.vas.funcall.impl;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.vas.funcall.IVasFunCallKuikly;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import g13.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/funcall/impl/VasFunCallKuiklyImpl;", "Lcom/tencent/mobileqq/vas/funcall/IVasFunCallKuikly;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "peerUin", "", "fcId", "", "mute", "", "addFunCallVideo", "onConnected", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lg13/b;", "mFunCallKuiklyManager", "Lg13/b;", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasFunCallKuiklyImpl implements IVasFunCallKuikly {

    @NotNull
    public static final String TAG = "VasFunCallKuiklyImpl";

    @Nullable
    private b mFunCallKuiklyManager;

    @Override // com.tencent.mobileqq.vas.funcall.IVasFunCallKuikly
    public void addFunCallVideo(@NotNull Activity activity, @NotNull ViewGroup parent, @NotNull String peerUin, int fcId, boolean mute) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        QLog.i(TAG, 1, "addFunCallVideo out Impl");
        if (this.mFunCallKuiklyManager == null) {
            this.mFunCallKuiklyManager = new b();
        }
        b bVar = this.mFunCallKuiklyManager;
        if (bVar != null) {
            bVar.b(activity, parent, peerUin, fcId, mute);
        }
    }

    @Override // com.tencent.mobileqq.vas.funcall.IVasFunCallKuikly
    public void onConnected() {
        b bVar = this.mFunCallKuiklyManager;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.tencent.mobileqq.vas.funcall.IVasFunCallKuikly
    public void onDestroy() {
        b bVar = this.mFunCallKuiklyManager;
        if (bVar != null) {
            bVar.e();
        }
        if (this.mFunCallKuiklyManager != null) {
            this.mFunCallKuiklyManager = null;
        }
    }
}

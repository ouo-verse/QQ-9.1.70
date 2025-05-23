package com.tencent.aelight.camera.ae.flashshow.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ms.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/receiver/LSMultiCameraBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;", "a", "Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;", "captureUnit", "<init>", "(Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;)V", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class LSMultiCameraBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LSMultiCameraUnit captureUnit;

    public LSMultiCameraBroadcastReceiver(LSMultiCameraUnit captureUnit) {
        Intrinsics.checkNotNullParameter(captureUnit, "captureUnit");
        this.captureUnit = captureUnit;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Activity A = this.captureUnit.A();
        if (A == null || A.isFinishing()) {
            return;
        }
        String action = intent.getAction();
        a.a("LSMultiCameraBroadcastReceiver", "LSMultiCameraBroadcastReceiver onReceive: action = " + action);
        if (Intrinsics.areEqual(AECameraConstants.AE_CAMERA_QZONE_RES_DOWNLOAD_FINISH_BROADCAST_ACTION, action)) {
            LSMultiCameraUnit lSMultiCameraUnit = this.captureUnit;
            if (lSMultiCameraUnit instanceof LSMultiCameraUnit) {
                lSMultiCameraUnit.l3();
            }
        }
    }
}

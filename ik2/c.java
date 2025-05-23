package ik2;

import android.os.Bundle;
import com.tencent.mobileqq.qqvideoedit.zplan.ipc.ZootopiaVideoCutModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lik2/c;", "", "", "b", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f407905a = new c();

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EIPCResult eIPCResult) {
        Bundle bundle;
        boolean z16;
        Bundle bundle2 = null;
        if (eIPCResult != null) {
            bundle = eIPCResult.data;
        } else {
            bundle = null;
        }
        QLog.i("GIFEncoderGenerator", 1, "init " + bundle);
        if (eIPCResult != null) {
            bundle2 = eIPCResult.data;
        }
        if (bundle2 == null) {
            return;
        }
        String string = bundle2.getString("param_feature_manager_so_path");
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("GIFEncoderGenerator", 1, "init bad soPath");
        } else {
            FeatureManager.setSoDir(string);
        }
    }

    public final void b() {
        boolean z16;
        String soDir = FeatureManager.getSoDir();
        if (soDir != null && soDir.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.i("GIFEncoderGenerator", 1, "init soDir already done!");
        } else {
            ZootopiaVideoCutModule.INSTANCE.a("action_init_light_res", null, new EIPCResultCallback() { // from class: ik2.b
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    c.c(eIPCResult);
                }
            });
        }
    }
}

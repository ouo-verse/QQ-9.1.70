package com.tencent.robot.aio.helper;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeatureFetchType;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeatureReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotSourceType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/aio/helper/n;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "", "e", "", "c", "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class n implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    private final boolean b() {
        Intent intent;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        FragmentActivity activity = aVar.c().getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra("key_babyQ_need_show_video", false);
    }

    private final String c() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        return aVar.g().r().c().j();
    }

    private final void e() {
        QLog.i("RobotNewerGuideHelper", 1, "sendNewerGuideReqToServer");
        RobotFeatureReq robotFeatureReq = new RobotFeatureReq();
        robotFeatureReq.robotUid = c();
        robotFeatureReq.fetchType = RobotFeatureFetchType.KSERVER;
        robotFeatureReq.sourceType = RobotSourceType.KUSERGUIDE;
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.fetchRobotFeatureWithReq(robotFeatureReq, new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.aio.helper.m
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
                public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                    n.g(i3, str, groupRobotProfile);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, String str, GroupRobotProfile groupRobotProfile) {
        QLog.i("RobotNewerGuideHelper", 1, "sendNewerGuideReqToServer result = " + i3 + " errorMsg = " + str);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.F1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotNewerGuideHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mAIOContext = param.a();
        if (b()) {
            e();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}

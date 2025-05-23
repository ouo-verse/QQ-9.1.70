package com.tencent.mtt.hippy.modules.nativemodules.utils;

import android.os.Vibrator;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
@HippyNativeModule(name = "UtilsModule")
/* loaded from: classes20.dex */
public class UtilsModule extends HippyNativeModuleBase {

    /* renamed from: a, reason: collision with root package name */
    private Vibrator f337560a;

    public UtilsModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "cancel")
    public void cancel() {
        if (this.f337560a == null) {
            this.f337560a = (Vibrator) this.mContext.getGlobalConfigs().getContext().getSystemService("vibrator");
        }
        Vibrator vibrator = this.f337560a;
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    @HippyMethod(name = "vibrate")
    public void vibrate(HippyArray hippyArray, int i3) {
        long[] jArr;
        if (this.f337560a == null) {
            this.f337560a = (Vibrator) this.mContext.getGlobalConfigs().getContext().getSystemService("vibrator");
        }
        if (this.f337560a != null) {
            if (hippyArray != null && hippyArray.size() > 0) {
                jArr = new long[hippyArray.size()];
                for (int i16 = 0; i16 < hippyArray.size(); i16++) {
                    try {
                        jArr[i16] = ((Integer) hippyArray.get(i16)).intValue();
                    } catch (Exception e16) {
                        LogUtils.d("UtilsModule", "vibrate: " + e16.getMessage());
                    }
                }
            } else {
                jArr = null;
            }
            if (jArr == null || jArr.length == 0) {
                jArr = new long[]{1000};
            }
            this.f337560a.vibrate(jArr, i3);
        }
    }
}

package com.tencent.mobileqq.qqecommerce.biz.hippy.module;

import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.UIThreadUtils;

/* compiled from: P */
@HippyNativeModule(name = "TKDToastModule")
/* loaded from: classes35.dex */
public class TKDToastModule extends HippyNativeModuleBase {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class CancelToastRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final Toast f262570d;

        CancelToastRunnable(Toast toast) {
            this.f262570d = toast;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f262570d.cancel();
        }
    }

    public TKDToastModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private int getIconType(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                return 0;
            }
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0(int i3, String str, int i16, Promise promise) {
        Toast show = QQToast.makeText(BaseApplicationImpl.getApplication(), getIconType(i3), str, i16).show();
        promise.resolve("");
        if (i16 == 0 || i16 == 1) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new CancelToastRunnable(show), i16);
    }

    @HippyMethod(name = "show")
    public void show(final String str, String str2, final int i3, String str3, final int i16, final Promise promise) {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hippy.module.a
            @Override // java.lang.Runnable
            public final void run() {
                TKDToastModule.this.lambda$show$0(i16, str, i3, promise);
            }
        });
    }
}

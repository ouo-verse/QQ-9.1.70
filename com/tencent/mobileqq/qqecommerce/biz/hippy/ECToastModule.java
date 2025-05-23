package com.tencent.mobileqq.qqecommerce.biz.hippy;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QFixToast;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyNativeModule(name = ECToastModule.TAG)
/* loaded from: classes35.dex */
public class ECToastModule extends HippyNativeModuleBase {
    private static final String TAG = "ECToastModule";

    /* compiled from: P */
    /* loaded from: classes35.dex */
    private static class CancelToastRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final Toast f262547d;

        CancelToastRunnable(Toast toast) {
            this.f262547d = toast;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f262547d.cancel();
        }
    }

    public ECToastModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Toast makeTextAndShow(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, "QCircleCustomToast show error, msg: " + str);
            return null;
        }
        QFixToast qFixToast = new QFixToast(BaseApplicationImpl.getApplication());
        qFixToast.setGravity(17, 0, 0);
        View inflate = LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(R.layout.g2p, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.f107206_s);
        qFixToast.setView(inflate);
        textView.setText(str);
        qFixToast.setDuration(i3);
        qFixToast.show();
        return qFixToast;
    }

    @HippyMethod(name = "show")
    public void show(final String str, String str2, final int i3, String str3, int i16, final Promise promise) {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hippy.ECToastModule.1
            @Override // java.lang.Runnable
            public void run() {
                int i17;
                Toast makeTextAndShow = ECToastModule.this.makeTextAndShow(str, i3 == 0 ? 0 : 1);
                promise.resolve("");
                if (makeTextAndShow == null || (i17 = i3) == 0 || i17 == 1) {
                    return;
                }
                ThreadManagerV2.getUIHandlerV2().postDelayed(new CancelToastRunnable(makeTextAndShow), i3);
            }
        });
    }
}

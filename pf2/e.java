package pf2;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018JM\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bj\u0004\u0018\u0001`\fH\u0002JE\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bj\u0004\u0018\u0001`\fH\u0002JE\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bj\u0004\u0018\u0001`\fH\u0002JG\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bj\u0004\u0018\u0001`\f\u00a8\u0006\u001a"}, d2 = {"Lpf2/e;", "", "", "code", "", "msg", "", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "view", "f", "d", "params", tl.h.F, "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {
    private final void d(final Activity activity, final View view, final Function1<Object, Unit> callback) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: pf2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.e(view, activity, this, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view, Activity activity, e this$0, Function1 function1) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int systemUiVisibility = view.getSystemUiVisibility();
        int i3 = systemUiVisibility & (-257) & (-1025) & (-3) & (-513) & (-8193) & MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS & (-5) & 4096;
        if (i3 != systemUiVisibility) {
            view.setSystemUiVisibility(i3);
        }
        activity.getWindow().clearFlags(134218752);
        activity.getWindow().setFlags(512, 512);
        view.setSystemUiVisibility(8192);
        this$0.c(0, "", true, function1);
        QLog.i("FullScreenImpl", 1, "cancelFullScreen success");
    }

    private final void f(final Activity activity, final View view, final Function1<Object, Unit> callback) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: pf2.c
            @Override // java.lang.Runnable
            public final void run() {
                e.g(view, activity, this, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View view, Activity activity, e this$0, Function1 function1) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int systemUiVisibility = view.getSystemUiVisibility();
        int i3 = systemUiVisibility | 256 | 1024 | 2 | 512 | 2048 | 4 | 4096;
        activity.getWindow().addFlags(67108864);
        if (i3 != systemUiVisibility) {
            view.setSystemUiVisibility(i3);
        }
        activity.getWindow().addFlags(134218752);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "activity.window.attributes");
            attributes.layoutInDisplayCutoutMode = 1;
            activity.getWindow().setAttributes(attributes);
        }
        this$0.c(0, "", true, function1);
        QLog.i("FullScreenImpl", 1, "toggleToFullScreen success");
    }

    private final void c(int code, String msg2, boolean result, Function1<Object, Unit> callback) {
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", code);
            jSONObject.put("msg", msg2);
            jSONObject.put("result", result);
            callback.invoke(jSONObject.toString());
        }
    }

    public final void h(String params, Activity activity, Function1<Object, Unit> callback) {
        if (activity != null && !activity.isFinishing()) {
            if (TextUtils.isEmpty(params)) {
                c(-2, "\u53c2\u6570\u4e3a\u7a7a", false, callback);
                return;
            }
            try {
                View decorView = activity.getWindow().getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
                Intrinsics.checkNotNull(params);
                if (new JSONObject(params).getBoolean(ReportConst.ACTION.FULLSCREEN)) {
                    f(activity, decorView, callback);
                } else {
                    d(activity, decorView, callback);
                }
                return;
            } catch (Exception e16) {
                QLog.e("FullScreenImpl", 1, "toggleToFullScreen exception", e16);
                c(-3, "\u5f02\u5e38:" + e16.getMessage(), false, callback);
                return;
            }
        }
        c(-1, "\u7cfb\u7edf\u9519\u8bef", false, callback);
    }
}

package og3;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0001*B'\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010!\u00a8\u0006+"}, d2 = {"Log3/d;", "Landroid/app/Dialog;", "", h.F, "d", "Landroid/view/Window;", "window", "i", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "e", "I", "getModId", "()I", "modId", "", "f", "Z", "isReceiveFirstFrame", "()Z", "isVideoReady", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "closeView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "titleView", BdhLogUtil.LogTag.Tag_Conn, "cancelView", "D", "confirmView", "<init>", "(Landroid/app/Activity;IZZ)V", "E", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends Dialog {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView cancelView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView confirmView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int modId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isReceiveFirstFrame;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isVideoReady;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView closeView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView titleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Activity activity, int i3, boolean z16, boolean z17) {
        super(activity, R.style.f2432107);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.modId = i3;
        this.isReceiveFirstFrame = z16;
        this.isVideoReady = z17;
        Window window = getWindow();
        if (window != null) {
            i(window);
        }
    }

    private final void d() {
        ImageView imageView = this.closeView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: og3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.e(d.this, view);
            }
        });
        TextView textView2 = this.cancelView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelView");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: og3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.f(d.this, view);
            }
        });
        TextView textView3 = this.confirmView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmView");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: og3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.g(d.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kg3.a.f412316a.f(this$0.modId, 2, this$0.isReceiveFirstFrame, this$0.isVideoReady);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kg3.a.f412316a.f(this$0.modId, 0, this$0.isReceiveFirstFrame, this$0.isVideoReady);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kg3.a.f412316a.f(this$0.modId, 1, this$0.isReceiveFirstFrame, this$0.isVideoReady);
        this$0.dismiss();
        this$0.activity.finish();
    }

    private final void i(Window window) {
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daw);
        h();
        d();
        kg3.a.f412316a.g(this.modId);
    }

    private final void h() {
        View findViewById = findViewById(R.id.pkj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.cloud_exit_dialog_close)");
        this.closeView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.pkl);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.cloud_exit_dialog_title)");
        this.titleView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.pki);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.cloud_exit_dialog_cancel)");
        this.cancelView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.pkk);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.cloud_exit_dialog_confirm)");
        this.confirmView = (TextView) findViewById4;
    }
}

package gt3;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QFixToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\t\u000eB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lgt3/a;", "", "", "text", "", "duration", "Landroid/content/Context;", "context", "", "a", "Landroid/widget/Toast;", "Landroid/widget/Toast;", "mToast", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "mTvToast", "<init>", "()V", "c", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f403346d = "QQLiveCustomToast";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Toast mToast;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTvToast;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lgt3/a$a;", "", "Lgt3/a;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gt3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a() {
            return b.f403349a.a();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lgt3/a$b;", "", "Lgt3/a;", "b", "Lgt3/a;", "a", "()Lgt3/a;", "setINSTANCE", "(Lgt3/a;)V", "INSTANCE", "<init>", "()V", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f403349a = new b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static a INSTANCE = new a();

        b() {
        }

        @NotNull
        public final a a() {
            return INSTANCE;
        }
    }

    public static /* synthetic */ void b(a aVar, String str, int i3, Context context, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            context = BaseApplication.context;
        }
        aVar.a(str, i3, context);
    }

    public final void a(@NotNull String text, int duration, @Nullable Context context) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (context != null && !TextUtils.isEmpty(text)) {
            Context applicationContext = context.getApplicationContext();
            if (this.mToast == null) {
                if (applicationContext != null) {
                    QFixToast qFixToast = new QFixToast(applicationContext.getApplicationContext());
                    this.mToast = qFixToast;
                    qFixToast.setGravity(17, 0, 0);
                    View inflate = LayoutInflater.from(applicationContext.getApplicationContext()).inflate(R.layout.h_b, (ViewGroup) null);
                    Intrinsics.checkNotNullExpressionValue(inflate, "from(context.application\u2026ustom_toast_layout, null)");
                    this.mTvToast = (TextView) inflate.findViewById(R.id.f107206_s);
                    Toast toast = this.mToast;
                    if (toast != null) {
                        toast.setView(inflate);
                    }
                } else {
                    QLog.d(f403346d, 1, "QQLiveCustomToast context is null, context: " + applicationContext + ", msg: " + text);
                    return;
                }
            }
            TextView textView = this.mTvToast;
            if (textView != null) {
                textView.setText(text);
            }
            Toast toast2 = this.mToast;
            if (toast2 != null) {
                toast2.setDuration(duration);
            }
            Toast toast3 = this.mToast;
            if (toast3 != null) {
                toast3.show();
                return;
            }
            return;
        }
        QLog.d(f403346d, 1, "QQLiveCustomToast show error, context: " + context + ", msg: " + text);
    }
}

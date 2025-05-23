package kk3;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0013"}, d2 = {"Lkk3/h;", "Lcom/tencent/mobileqq/qqfloatingwindow/a;", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "floatParams", "Landroid/view/View;", "customView", "", "j", "", "updateFloatingView", "", "isVisible", "N", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends com.tencent.mobileqq.qqfloatingwindow.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final String f412605e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkk3/h$a;", "", "", "CLASS_NAME", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kk3.h$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return h.f412605e;
        }

        Companion() {
        }
    }

    static {
        String name = h.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "MeetingScreenCaptureFloa\u2026wWrapper::class.java.name");
        f412605e = name;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void N(boolean isVisible) {
        super.N(isVisible);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(FloatingScreenParams floatParams, View customView) {
        updateFloatingView();
        return super.j(floatParams, customView);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        super.updateFloatingView();
        N(false);
    }
}

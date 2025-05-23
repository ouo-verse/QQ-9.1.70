package mh4;

import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.app.QBaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lmh4/i;", "", "", "b", "a", "d", "Lrr1/i;", "notifyData", "c", "Lgh4/e;", "Lgh4/e;", "mHall", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "", "Z", "isExpand", "", "Ljava/lang/Integer;", "originWindowSoftInputMode", "<init>", "(Lgh4/e;Lcom/tencent/mobileqq/app/QBaseActivity;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gh4.e mHall;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity qBaseActivity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isExpand;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer originWindowSoftInputMode;

    public i(@NotNull gh4.e mHall, @NotNull QBaseActivity qBaseActivity) {
        Intrinsics.checkNotNullParameter(mHall, "mHall");
        Intrinsics.checkNotNullParameter(qBaseActivity, "qBaseActivity");
        this.mHall = mHall;
        this.qBaseActivity = qBaseActivity;
        this.isExpand = true;
    }

    public final void a() {
        Integer num;
        if (this.isExpand && (num = this.originWindowSoftInputMode) != null) {
            int intValue = num.intValue() & 15;
            Window window = this.qBaseActivity.getWindow();
            if (window != null) {
                window.setSoftInputMode(intValue | 16);
            }
        }
    }

    public final void b() {
        Integer num;
        Window window = this.qBaseActivity.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                num = Integer.valueOf(attributes.softInputMode);
            } else {
                num = null;
            }
            this.originWindowSoftInputMode = num;
            com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "apply adjust resize # onCreate");
            a();
        }
    }

    public final void c(@Nullable rr1.i notifyData) {
        boolean z16;
        if (notifyData != null && notifyData.e() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.isExpand = true;
            a();
        } else {
            this.isExpand = false;
            d();
        }
    }

    public final void d() {
        Integer num = this.originWindowSoftInputMode;
        if (num != null) {
            int intValue = num.intValue();
            try {
                Window window = this.qBaseActivity.getWindow();
                if (window != null) {
                    window.setSoftInputMode(intValue);
                }
            } catch (Exception unused) {
            }
        }
    }
}

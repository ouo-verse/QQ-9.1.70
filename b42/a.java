package b42;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateView;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lb42/a;", "Lb42/b;", "Ljx0/a;", "j", "Lcom/tencent/mobileqq/icgame/room/component/a;", "i", "Lcom/tencent/mobileqq/qqlive/callback/gift/OnQueryGiftIconCallback;", "callback", "", "isForce", "", "a", "fullScreen", "c", "", "text", "g", "Lcom/tencent/mobileqq/icgame/room/touchdelegate/TouchDelegateView;", "f", "Landroid/view/View;", "e", "d", "Landroid/widget/LinearLayout;", "b", "Landroid/widget/FrameLayout;", h.F, "Lf32/b;", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f32.b connectorContext;

    public a(@NotNull f32.b connectorContext) {
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
        this.connectorContext = connectorContext;
    }

    private final com.tencent.mobileqq.icgame.room.component.a i() {
        return (com.tencent.mobileqq.icgame.room.component.a) com.tencent.mobileqq.icgame.base.room.b.d(this.connectorContext, com.tencent.mobileqq.icgame.room.component.a.class);
    }

    private final jx0.a j() {
        jx0.a aVar = (jx0.a) com.tencent.mobileqq.icgame.base.room.b.d(this.connectorContext, jx0.a.class);
        if (aVar == null) {
            QLog.i("ICGameAudienceSupportImpl", 1, "VerifyGiftComponent == null");
        }
        return aVar;
    }

    @Override // b42.b
    public void a(@Nullable OnQueryGiftIconCallback callback, boolean isForce) {
        jx0.a j3 = j();
        if (j3 != null) {
            j3.n(callback, isForce);
        }
    }

    @Override // b42.b
    @Nullable
    public LinearLayout b() {
        com.tencent.mobileqq.icgame.room.component.a i3 = i();
        if (i3 != null) {
            return i3.A();
        }
        return null;
    }

    @Override // b42.b
    public void c(boolean fullScreen) {
        com.tencent.mobileqq.icgame.room.component.a i3 = i();
        if (i3 != null) {
            i3.X(fullScreen);
        }
    }

    @Override // b42.b
    @Nullable
    public View d() {
        com.tencent.mobileqq.icgame.room.component.a i3 = i();
        if (i3 != null) {
            return i3.z();
        }
        return null;
    }

    @Override // b42.b
    @Nullable
    public View e() {
        com.tencent.mobileqq.icgame.room.component.a i3 = i();
        if (i3 != null) {
            return i3.D();
        }
        return null;
    }

    @Override // b42.b
    @Nullable
    public TouchDelegateView f() {
        com.tencent.mobileqq.icgame.room.component.a i3 = i();
        if (i3 != null) {
            return i3.G();
        }
        return null;
    }

    @Override // b42.b
    public void g(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        com.tencent.mobileqq.icgame.room.component.a i3 = i();
        if (i3 != null) {
            i3.P(text);
        }
    }

    @Override // b42.b
    @Nullable
    public FrameLayout h() {
        com.tencent.mobileqq.icgame.room.component.a i3 = i();
        if (i3 != null) {
            return i3.B();
        }
        return null;
    }
}

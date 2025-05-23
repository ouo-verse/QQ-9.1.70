package com.tencent.mobileqq.vip.api.impl;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.api.impl.VipFrameIconDrawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipFrameIconDrawable$b;", "invoke", "()Lcom/tencent/mobileqq/vip/api/impl/VipFrameIconDrawable$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes20.dex */
final class VipFrameIconDrawable$draw$1 extends Lambda implements Function0<VipFrameIconDrawable.b> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $animTimeMillis;
    final /* synthetic */ Ref.IntRef $nextIndex;
    final /* synthetic */ VipFrameIconDrawable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipFrameIconDrawable$draw$1(long j3, VipFrameIconDrawable vipFrameIconDrawable, Ref.IntRef intRef) {
        super(0);
        this.$animTimeMillis = j3;
        this.this$0 = vipFrameIconDrawable;
        this.$nextIndex = intRef;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), vipFrameIconDrawable, intRef);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipFrameIconDrawable this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidateSelf();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final VipFrameIconDrawable.b invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (VipFrameIconDrawable.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final VipFrameIconDrawable vipFrameIconDrawable = this.this$0;
        uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vip.api.impl.x
            @Override // java.lang.Runnable
            public final void run() {
                VipFrameIconDrawable$draw$1.b(VipFrameIconDrawable.this);
            }
        }, this.$animTimeMillis);
        Drawable drawable = this.this$0.z().get(this.this$0.A());
        Intrinsics.checkNotNullExpressionValue(drawable, "allDrawable[lastIndex]");
        Drawable drawable2 = this.this$0.z().get(this.$nextIndex.element);
        Intrinsics.checkNotNullExpressionValue(drawable2, "allDrawable[nextIndex]");
        return new VipFrameIconDrawable.b(drawable, drawable2);
    }
}

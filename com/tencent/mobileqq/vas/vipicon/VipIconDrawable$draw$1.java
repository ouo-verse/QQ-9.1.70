package com.tencent.mobileqq.vas.vipicon;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.vipicon.VipIcon;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable$b;", "invoke", "()Lcom/tencent/mobileqq/vas/vipicon/VipIconDrawable$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes20.dex */
final class VipIconDrawable$draw$1 extends Lambda implements Function0<VipIcon.b> {
    final /* synthetic */ long $animTimeMillis;
    final /* synthetic */ Ref.IntRef $nextIndex;
    final /* synthetic */ VipIcon this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipIconDrawable$draw$1(long j3, VipIcon vipIcon, Ref.IntRef intRef) {
        super(0);
        this.$animTimeMillis = j3;
        this.this$0 = vipIcon;
        this.$nextIndex = intRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipIcon this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidateSelf();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final VipIcon.b invoke() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        int i3;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final VipIcon vipIcon = this.this$0;
        uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.j
            @Override // java.lang.Runnable
            public final void run() {
                VipIconDrawable$draw$1.b(VipIcon.this);
            }
        }, this.$animTimeMillis);
        copyOnWriteArrayList = this.this$0.allDrawable;
        i3 = this.this$0.lastIndex;
        Object obj = copyOnWriteArrayList.get(i3);
        Intrinsics.checkNotNullExpressionValue(obj, "allDrawable[lastIndex]");
        copyOnWriteArrayList2 = this.this$0.allDrawable;
        Object obj2 = copyOnWriteArrayList2.get(this.$nextIndex.element);
        Intrinsics.checkNotNullExpressionValue(obj2, "allDrawable[nextIndex]");
        return new VipIcon.b((Drawable) obj, (Drawable) obj2);
    }
}

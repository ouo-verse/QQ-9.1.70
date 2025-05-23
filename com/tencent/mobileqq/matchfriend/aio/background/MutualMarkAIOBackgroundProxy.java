package com.tencent.mobileqq.matchfriend.aio.background;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014J\b\u0010\f\u001a\u00020\tH\u0016J(\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/MutualMarkAIOBackgroundProxy;", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy;", "Landroid/view/View;", "k", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$e;", "f", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$b;", "g", "Lkotlin/Function0;", "", "block", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "left", "top", "right", "bottom", "t", "Landroid/os/Handler;", "i", "Lkotlin/Lazy;", "v", "()Landroid/os/Handler;", "subHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MutualMarkAIOBackgroundProxy extends BaseMutualMarkAIOBackgroundProxy {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy subHandler;

    public MutualMarkAIOBackgroundProxy(Context context) {
        super(context);
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.matchfriend.aio.background.MutualMarkAIOBackgroundProxy$subHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(ThreadManagerV2.getQQCommonThreadLooper());
            }
        });
        this.subHandler = lazy;
    }

    private final Handler v() {
        return (Handler) this.subHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy
    public BaseMutualMarkAIOBackgroundProxy.e f() {
        return new f();
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy
    public BaseMutualMarkAIOBackgroundProxy.b g() {
        return new PagViewUpdater();
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy
    public View k() {
        return new StrangerMutualMarkBackground(i());
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy
    public void m() {
        super.m();
        v().removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy
    protected void r(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        v().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.background.c
            @Override // java.lang.Runnable
            public final void run() {
                MutualMarkAIOBackgroundProxy.w(Function0.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy
    public void t(int left, int top, int right, int bottom) {
        View h16 = h();
        StrangerMutualMarkBackground strangerMutualMarkBackground = h16 instanceof StrangerMutualMarkBackground ? (StrangerMutualMarkBackground) h16 : null;
        if (strangerMutualMarkBackground != null) {
            strangerMutualMarkBackground.a(left, top, right, bottom);
        }
    }
}

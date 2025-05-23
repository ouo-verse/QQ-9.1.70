package df2;

import af2.d;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Ldf2/a;", "", "", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRegisteredScreenCallback", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f393675a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isRegisteredScreenCallback = new AtomicBoolean(false);

    a() {
    }

    public final void a() {
        if (isRegisteredScreenCallback.compareAndSet(false, true)) {
            GuardManagerCallbackDispatcher.registerCallBack(new C10175a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"df2/a$a", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: df2.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10175a implements IGuardInterface {
        C10175a() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            HashMap hashMapOf;
            d dVar = d.f26007a;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("PARAM_SCREEN_RECEIVER_ACTION", IECScreenReceiver.ACTION_QQ_BACKGROUND));
            d.b(dVar, 113, hashMapOf, null, 4, null);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            HashMap hashMapOf;
            d dVar = d.f26007a;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("PARAM_SCREEN_RECEIVER_ACTION", IECScreenReceiver.ACTION_QQ_FOREGROUND));
            d.b(dVar, 113, hashMapOf, null, 4, null);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
            HashMap hashMapOf;
            HashMap hashMapOf2;
            if (isEnabled) {
                d dVar = d.f26007a;
                hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("PARAM_SCREEN_RECEIVER_ACTION", IECScreenReceiver.ACTION_SCREEN_ON));
                d.b(dVar, 113, hashMapOf2, null, 4, null);
            } else {
                d dVar2 = d.f26007a;
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("PARAM_SCREEN_RECEIVER_ACTION", IECScreenReceiver.ACTION_SCREEN_OFF));
                d.b(dVar2, 113, hashMapOf, null, 4, null);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
        }
    }
}

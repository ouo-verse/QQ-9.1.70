package du2;

import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import fu2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u001b\b\u0000\u0018\u0000 \u00052\u00020\u00012\u00020\u0002:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001c\u00a8\u0006 "}, d2 = {"Ldu2/b;", "Lfu2/b;", "Lau2/b;", "", "j", "f", "b", "", "a", "d", "e", "Lfu2/b$a;", "callback", "c", "Z", "isAttachToPage", "Lfu2/b$a;", h.F, "()Lfu2/b$a;", IECSearchBar.METHOD_SET_CALLBACK, "(Lfu2/b$a;)V", "Lcom/tencent/biz/qcircleshadow/lib/HostStaticInvokeHelper$NetworkChangedObserver;", "Lcom/tencent/biz/qcircleshadow/lib/HostStaticInvokeHelper$NetworkChangedObserver;", "netObserver", "Lcom/tencent/mobileqq/app/guard/GuardManager;", "Lcom/tencent/mobileqq/app/guard/GuardManager;", "guardManager", "du2/b$b", "Ldu2/b$b;", "guardCallback", "<init>", "(Z)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements fu2.b, au2.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isAttachToPage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b.a callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HostStaticInvokeHelper.NetworkChangedObserver netObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GuardManager guardManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C10202b guardCallback;

    public b(boolean z16) {
        this.isAttachToPage = z16;
        HostStaticInvokeHelper.NetworkChangedObserver networkChangedObserver = new HostStaticInvokeHelper.NetworkChangedObserver() { // from class: du2.a
            @Override // com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.NetworkChangedObserver
            public final void onNetworkChanged(boolean z17) {
                b.i(b.this, z17);
            }
        };
        this.netObserver = networkChangedObserver;
        GuardManager guardManager = GuardManager.sInstance;
        this.guardManager = guardManager;
        C10202b c10202b = new C10202b();
        this.guardCallback = c10202b;
        if (guardManager != null) {
            guardManager.registerCallBack(c10202b);
        }
        HostStaticInvokeHelper.addNetworkChangedObserver(networkChangedObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.a aVar = this$0.callback;
        if (aVar != null) {
            aVar.c(z16);
        }
    }

    private final void j() {
        b.a aVar = this.callback;
        if (aVar != null) {
            aVar.b(this.isAttachToPage);
        }
    }

    @Override // fu2.b
    /* renamed from: a, reason: from getter */
    public boolean getIsAttachToPage() {
        return this.isAttachToPage;
    }

    @Override // au2.b
    public void b() {
        this.isAttachToPage = false;
        j();
        GuardManager guardManager = this.guardManager;
        if (guardManager != null) {
            guardManager.unregisterCallback(this.guardCallback);
        }
        HostStaticInvokeHelper.removeNetworkChangeObserver(this.netObserver);
    }

    @Override // fu2.b
    public void c(@NotNull b.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // fu2.b
    public boolean d() {
        return HostStaticInvokeHelper.isNetworkValid();
    }

    @Override // fu2.b
    public boolean e() {
        GuardManager guardManager = this.guardManager;
        if (guardManager != null) {
            return guardManager.isApplicationForeground();
        }
        return false;
    }

    @Override // au2.b
    public void f() {
        this.isAttachToPage = true;
        j();
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final b.a getCallback() {
        return this.callback;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"du2/b$b", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: du2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C10202b implements IGuardInterface {
        C10202b() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            b.a callback = b.this.getCallback();
            if (callback != null) {
                callback.a(false);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            b.a callback = b.this.getCallback();
            if (callback != null) {
                callback.a(true);
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

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
        }
    }
}

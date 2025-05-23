package l33;

import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin;
import com.tencent.mobileqq.vip.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.treasurecard.bean.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import so4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\"\u0010\u0014\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Ll33/b;", "Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "", "init", "", "from", "", "intervalTime", "Lso4/a$a;", "listener", "Lso4/a;", "", "obtainCardState", "treasureCardState", "Lcom/tencent/mobileqq/vas/treasurecard/VasFtCard;", "obtainCardInfo", "", "clearCacheAndRequest", "d", "Z", "isInit", "()Z", "setInit", "(Z)V", "e", "Lso4/a;", "getManager", "()Lso4/a;", "manager", "getManagerName", "()Ljava/lang/String;", "managerName", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements IVasFTManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final so4.a manager = new com.tencent.treasurecard.manager.b("", "");

    @Override // com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager
    public boolean clearCacheAndRequest() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        String name = b.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.javaClass.name");
        return name;
    }

    @Override // com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager
    public void init() {
        this.manager.c(MobileQQ.sMobileQQ.waitAppRuntime(null).getApplicationContext(), 10001, 0L, new a.InterfaceC11243a() { // from class: l33.a
            @Override // so4.a.InterfaceC11243a
            public final void onChange(int i3) {
                b.b(i3);
            }
        });
        this.isInit = true;
    }

    @Override // com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager
    @Nullable
    public VasFtCard obtainCardInfo(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (!this.isInit) {
            init();
        }
        com.tencent.treasurecard.report.a.a().c(from, "");
        d b16 = this.manager.b();
        return new VasFtCard(b16.a(BaseApplication.getContext()).optString("orderUrl"), "", b16.a(BaseApplication.getContext()).optString("message"));
    }

    @Override // com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager
    public int obtainCardState(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (!this.isInit) {
            init();
        }
        com.tencent.treasurecard.report.a.a().c(from, "");
        int a16 = e.a();
        int a17 = this.manager.a();
        int i3 = 1;
        if (a16 != 1) {
            if (a17 == 1) {
                i3 = 2;
            } else if (a16 != 0 && a17 != 0) {
                i3 = -1;
            } else {
                i3 = 0;
            }
        }
        QLog.d(TreasureCardJsPlugin.BUSINESS_NAME, 2, "obtainCardState " + from + " , " + i3);
        return i3;
    }

    @Override // com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager
    public int treasureCardState(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (!this.isInit) {
            init();
        }
        com.tencent.treasurecard.report.a.a().c(from, "");
        return this.manager.a();
    }

    @Override // com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager
    @NotNull
    public so4.a init(@NotNull String from, long intervalTime, @NotNull a.InterfaceC11243a listener) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.treasurecard.manager.b bVar = new com.tencent.treasurecard.manager.b(from, "");
        bVar.c(MobileQQ.sMobileQQ.waitAppRuntime(null).getApplicationContext(), 10001, intervalTime, listener);
        this.isInit = true;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3) {
    }
}

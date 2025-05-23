package il2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentLoadSoUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002\u00a8\u0006\f"}, d2 = {"Lil2/b;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "callback", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f407933a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"il2/b$a", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements gl0.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f407934a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Boolean, Unit> function1) {
            this.f407934a = function1;
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, @Nullable String errMsg) {
            QLog.i("QWallet.Pet.SupportUtils", 1, "loadFilamentSo so: " + isSuccess + " " + downloadSo + " " + errCode + " " + errMsg);
            this.f407934a.invoke(Boolean.valueOf(isSuccess));
        }
    }

    b() {
    }

    public final void a(@NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IZPlanFilamentLoadSoUtil) QRoute.api(IZPlanFilamentLoadSoUtil.class)).downloadAndLoadSo(new a(callback));
    }
}

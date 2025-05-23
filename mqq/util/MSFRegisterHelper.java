package mqq.util;

import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lmqq/util/MSFRegisterHelper;", "", "()V", "TAG", "", "useAsync", "", "getUseAsync", "()Z", "useAsync$delegate", "Lkotlin/Lazy;", "doRegisterMSFService", "", "ar", "Lmqq/app/AppRuntime;", "registerMSFService", "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class MSFRegisterHelper {

    @NotNull
    public static final MSFRegisterHelper INSTANCE = new MSFRegisterHelper();

    @NotNull
    private static final String TAG = "MSFRegisterHelper";

    /* renamed from: useAsync$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy useAsync;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: mqq.util.MSFRegisterHelper$useAsync$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean z16;
                try {
                    z16 = MqqConfigUtil.INSTANCE.getConfigFile("runtime_register_msf_service").exists();
                } catch (Exception e16) {
                    QLog.e("MSFRegisterHelper", 1, e16, new Object[0]);
                    z16 = false;
                }
                QLog.d("MSFRegisterHelper", 1, "useAsync result: " + z16);
                return Boolean.valueOf(z16);
            }
        });
        useAsync = lazy;
    }

    MSFRegisterHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doRegisterMSFService(AppRuntime ar3) {
        ar3.getService().msfSub.registerMsfService();
    }

    private final boolean getUseAsync() {
        return ((Boolean) useAsync.getValue()).booleanValue();
    }

    public final void registerMSFService(@NotNull final AppRuntime ar3) {
        Intrinsics.checkNotNullParameter(ar3, "ar");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) && getUseAsync()) {
            CoroutinesHelper.INSTANCE.asyncCall(new Function0<Unit>() { // from class: mqq.util.MSFRegisterHelper$registerMSFService$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MSFRegisterHelper.INSTANCE.doRegisterMSFService(AppRuntime.this);
                }
            });
        } else {
            doRegisterMSFService(ar3);
        }
    }
}

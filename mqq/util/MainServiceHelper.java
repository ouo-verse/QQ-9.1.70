package mqq.util;

import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lmqq/util/MainServiceHelper;", "", "()V", "TAG", "", "switchMainThread", "", "getSwitchMainThread", "()Z", "switchMainThread$delegate", "Lkotlin/Lazy;", "isSwitchMainThread", "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class MainServiceHelper {

    @NotNull
    public static final MainServiceHelper INSTANCE = new MainServiceHelper();

    @NotNull
    private static final String TAG = "MainServiceHelper";

    /* renamed from: switchMainThread$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy switchMainThread;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: mqq.util.MainServiceHelper$switchMainThread$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean z16;
                try {
                    z16 = MqqConfigUtil.INSTANCE.getConfigFile("main_service_popup_window").exists();
                } catch (Exception e16) {
                    QLog.e("MainServiceHelper", 1, e16, new Object[0]);
                    z16 = false;
                }
                QLog.d("MainServiceHelper", 1, "switchMainThread result: " + z16);
                return Boolean.valueOf(z16);
            }
        });
        switchMainThread = lazy;
    }

    MainServiceHelper() {
    }

    private final boolean getSwitchMainThread() {
        return ((Boolean) switchMainThread.getValue()).booleanValue();
    }

    public final boolean isSwitchMainThread() {
        return getSwitchMainThread();
    }
}

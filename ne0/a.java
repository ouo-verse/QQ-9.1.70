package ne0;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.interfaces.IContextOwner;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes5.dex */
public final /* synthetic */ class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static ViewModel a(IPartHost iPartHost, ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        String str2;
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStoreOwner);
        if (str == null) {
            str2 = cls.getCanonicalName();
            Objects.requireNonNull(str2);
        } else {
            str2 = str + cls.getCanonicalName();
        }
        ViewModel viewModel = viewModelProvider.get(str2, cls);
        if ((viewModel instanceof IContextOwner) && iPartHost.getHostActivity() != null) {
            ((IContextOwner) viewModel).setContextHashCode(iPartHost.getHostActivity().hashCode());
        }
        return viewModel;
    }

    public static ViewModel b(IPartHost iPartHost, @NonNull Class cls) {
        return iPartHost.getViewModel("", cls);
    }

    public static ViewModel c(IPartHost iPartHost, String str, @NonNull Class cls) {
        return iPartHost.getViewModel(iPartHost, str, cls);
    }

    @Deprecated
    public static Object d(IPartHost iPartHost) {
        return null;
    }

    public static boolean f(IPartHost iPartHost) {
        return false;
    }

    @Deprecated
    public static void e(IPartHost iPartHost, String str, String str2, long j3) {
    }
}

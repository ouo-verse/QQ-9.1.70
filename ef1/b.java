package ef1;

import androidx.annotation.CallSuper;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0015J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0017J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lef1/b;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Landroidx/lifecycle/ViewModelStoreOwner;", "", "L1", "onCleared", "", "account", "onAccountChanged", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Lcom/tencent/common/app/AppInterface;", "i", "Lcom/tencent/common/app/AppInterface;", "_app", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/ViewModelStore;", "_viewModelStore", "M1", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class b extends ViewModel implements com.tencent.mobileqq.guild.base.repository.a, ViewModelStoreOwner {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AppInterface _app = ch.l();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewModelStore _viewModelStore = new ViewModelStore();

    @JvmOverloads
    public b() {
        L1();
    }

    private final void L1() {
        AccountChangedNotifier.f214789d.a(this);
    }

    @NotNull
    public final AppInterface M1() {
        AppInterface appInterface = this._app;
        if (appInterface == null) {
            AppInterface l3 = ch.l();
            Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
            return l3;
        }
        return appInterface;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore, reason: from getter */
    public ViewModelStore get_viewModelStore() {
        return this._viewModelStore;
    }

    @CallSuper
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this._app = ch.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    @CallSuper
    public void onCleared() {
        this._viewModelStore.clear();
        AccountChangedNotifier.f214789d.d(this);
        this._app = null;
    }
}

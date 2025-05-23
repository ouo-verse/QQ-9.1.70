package com.tencent.mobileqq.troopmanage.repo;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/repo/h;", "", "", "troopUin", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository;", "b", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Landroidx/lifecycle/ViewModelProvider;", "c", "", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "uin2RepoCacheMap", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f303236a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, TroopManageRepository> uin2RepoCacheMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/h$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f303238a;

        a(String str) {
            this.f303238a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            h hVar = h.f303236a;
            String str = this.f303238a;
            if (str == null) {
                str = "";
            }
            return new TroopManageViewModel(hVar.b(str));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63077);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f303236a = new h();
            uin2RepoCacheMap = new ConcurrentHashMap<>();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopManageRepository b(String troopUin) {
        ConcurrentHashMap<String, TroopManageRepository> concurrentHashMap = uin2RepoCacheMap;
        TroopManageRepository troopManageRepository = concurrentHashMap.get(troopUin);
        if (troopManageRepository == null) {
            TroopManageRepository troopManageRepository2 = new TroopManageRepository();
            concurrentHashMap.put(troopUin, troopManageRepository2);
            return troopManageRepository2;
        }
        return troopManageRepository;
    }

    @NotNull
    public final ViewModelProvider c(@Nullable String troopUin, @NotNull ViewModelStoreOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewModelProvider) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) owner);
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        return new ViewModelProvider(owner.getViewModelStore(), new a(troopUin));
    }

    public final void d(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin);
            return;
        }
        ConcurrentHashMap<String, TroopManageRepository> concurrentHashMap = uin2RepoCacheMap;
        if (troopUin == null) {
            troopUin = "";
        }
        concurrentHashMap.remove(troopUin);
    }
}

package com.tencent.qqnt.chats.main.vm;

import android.content.Context;
import android.os.Looper;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.uistate.a;
import com.tencent.qqnt.chats.core.userintent.a;
import com.tencent.qqnt.chats.main.api.IMainChatsUnreadHelper;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.MainRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.f;
import com.tencent.qqnt.chats.main.vm.usecase.g;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001,B\u001f\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/MainChatListVM;", "Lcom/tencent/qqnt/chats/main/vm/ChatsListVM;", "", "h0", "m0", "i0", "j0", "Lkotlin/Function0;", "block", "k0", "", "isAccountChange", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/chats/core/uistate/a$b;", BdhLogUtil.LogTag.Tag_Conn, "T", "U", "X", "Lcom/tencent/qqnt/chats/core/userintent/b;", "userIntent", "M", "W", "V", "Lcom/tencent/qqnt/chats/main/vm/usecase/g;", "w", "Lcom/tencent/qqnt/chats/main/vm/usecase/g;", "thirdViewClickUseCase", "Lcom/tencent/qqnt/chats/main/vm/usecase/f;", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/chats/main/vm/usecase/f;", "searchClickUseCase", "y", "Z", "isResume", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MainChatListVM extends ChatsListVM {
    static IPatchRedirector $redirector_;

    @Nullable
    private static a.b A;

    @Nullable
    private static String B;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g thirdViewClickUseCase;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f searchClickUseCase;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean isResume;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/MainChatListVM$a;", "", "", "IS_NEED_SK_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.MainChatListVM$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/chats/main/vm/MainChatListVM$b", "Lcom/tencent/qqnt/chats/main/vm/datasource/d;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "curSpecifyInfo", "", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.qqnt.chats.main.vm.datasource.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainChatListVM.this);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.d
        public void a(int result, @Nullable String errMsg, @Nullable RecentContactInfo curSpecifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, curSpecifyInfo);
            } else {
                MainChatListVM.this.n(new a.l(result, errMsg, curSpecifyInfo));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45360);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
            B = "";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainChatListVM(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @NotNull IRecentContactRepo recentContactRepo) {
        super(scope, new com.tencent.qqnt.chats.core.a(context, 1), recentContactRepo);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scope, context, recentContactRepo);
        } else {
            this.thirdViewClickUseCase = new g();
            this.searchClickUseCase = new f(B().a());
        }
    }

    private final void h0() {
        H().q(new b());
    }

    private final void i0() {
        a.b bVar;
        com.tencent.qqnt.chats.core.uistate.b value = L().getValue();
        String str = null;
        if (value instanceof a.b) {
            bVar = (a.b) value;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        QLog.i("MainChatListVM", 1, "cacheState, size: " + bVar.d().size());
        A = bVar.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        }
        B = str;
    }

    private final void j0() {
        MainRecentContactRepo mainRecentContactRepo;
        if (!H().c()) {
            IRecentContactRepo H = H();
            if (H instanceof MainRecentContactRepo) {
                mainRecentContactRepo = (MainRecentContactRepo) H;
            } else {
                mainRecentContactRepo = null;
            }
            if (mainRecentContactRepo != null) {
                mainRecentContactRepo.w();
            }
        }
    }

    private final void k0(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            J().post(new Runnable() { // from class: com.tencent.qqnt.chats.main.vm.e
                @Override // java.lang.Runnable
                public final void run() {
                    MainChatListVM.l0(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    private final void m0() {
        H().q(null);
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    @NotNull
    public a.b C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (Intrinsics.areEqual(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), B) && A != null) {
            QLog.d("MainChatListVM", 1, "getInitState use cache");
            a.b bVar = A;
            A = null;
            Intrinsics.checkNotNull(bVar);
            return bVar;
        }
        return super.C();
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM, com.tencent.qqnt.chats.core.mvi.a
    /* renamed from: M */
    public void l(@NotNull com.tencent.qqnt.chats.core.userintent.b userIntent) {
        List<com.tencent.qqnt.chats.core.uievent.b> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof a.m) {
            a.m mVar = (a.m) userIntent;
            Object a17 = this.thirdViewClickUseCase.a(B().a(), mVar.b(), mVar.a());
            if (Result.m482isFailureimpl(a17)) {
                a17 = null;
            }
            com.tencent.qqnt.chats.main.vm.usecase.result.a aVar = (com.tencent.qqnt.chats.main.vm.usecase.result.a) a17;
            if (aVar != null && (a16 = aVar.a()) != null) {
                Iterator<T> it = a16.iterator();
                while (it.hasNext()) {
                    n((com.tencent.qqnt.chats.core.uievent.b) it.next());
                }
            }
            QLog.d("MainChatListVM", 1, "OnThirdViewClick " + mVar.b());
            return;
        }
        if (userIntent instanceof a.l) {
            this.searchClickUseCase.a();
            com.tencent.qqnt.chats.api.b e16 = e();
            if (e16 != null) {
                e16.c();
                return;
            }
            return;
        }
        if (userIntent instanceof a.h) {
            ((IMainChatsUnreadHelper) QRoute.api(IMainChatsUnreadHelper.class)).notifyClearItem(((a.h) userIntent).b());
            super.l(userIntent);
        } else if (userIntent instanceof a.e) {
            H().m();
        } else if (userIntent instanceof a.f) {
            super.l(userIntent);
            com.tencent.qqnt.chats.core.utils.a.f355091a.a(((a.f) userIntent).b());
        } else {
            super.l(userIntent);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public boolean Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void R(boolean isAccountChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isAccountChange);
            return;
        }
        super.R(isAccountChange);
        com.tencent.qqnt.chats.c.f354431a.a(this);
        k0(new Function0<Unit>() { // from class: com.tencent.qqnt.chats.main.vm.MainChatListVM$onCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainChatListVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MainChatListVM.this.n(a.e.f355009a);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        h0();
        ((IBusManager) QRoute.api(IBusManager.class)).reInit();
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void T(boolean isAccountChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isAccountChange);
            return;
        }
        super.T(isAccountChange);
        com.tencent.qqnt.chats.c.f354431a.c();
        ((IBusManager) QRoute.api(IBusManager.class)).clearAndStop();
        m0();
        if (!isAccountChange) {
            i0();
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.U();
            j0();
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.V();
            this.isResume = false;
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.W();
            this.isResume = true;
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.X();
            com.tencent.qqnt.chats.data.persistent.c.f355136a.e(true);
        }
    }
}

package com.tencent.qqnt.chats.biz.qqstranger;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IStrangerChatsApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.userintent.a;
import com.tencent.qqnt.chats.main.vm.ChatsListVM;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.biz.QQStrangerChatsRepo;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.msg.f;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u0016B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J$\u0010\u0014\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0016\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/chats/biz/qqstranger/QQStrangerChatListVM;", "Lcom/tencent/qqnt/chats/main/vm/ChatsListVM;", "Lcom/tencent/qqnt/chats/api/e;", "Lcom/tencent/qqnt/chats/biz/qqstranger/c;", "intent", "", "h0", "Lcom/tencent/qqnt/chats/biz/qqstranger/d;", "i0", "Lcom/tencent/qqnt/chats/core/userintent/b;", "userIntent", "M", "", "isAccountChange", BdhLogUtil.LogTag.Tag_Req, "T", "", "", "removeSets", "addSets", "c", "setTops", "a", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "w", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class QQStrangerChatListVM extends ChatsListVM implements com.tencent.qqnt.chats.api.e {
    static IPatchRedirector $redirector_;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/biz/qqstranger/QQStrangerChatListVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.qqstranger.QQStrangerChatListVM$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43265);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerChatListVM(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @NotNull IRecentContactRepo recentContactRepo) {
        super(scope, new com.tencent.qqnt.chats.core.a(context, 8), recentContactRepo);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scope, context, recentContactRepo);
        }
    }

    private final void h0(final c intent) {
        H().l(new Function1<g, Boolean>() { // from class: com.tencent.qqnt.chats.biz.qqstranger.QQStrangerChatListVM$handleStrangerChatsListUserIntent$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull g it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(c.this.a().contains(it.k()));
            }
        }, QQStrangerChatListVM$handleStrangerChatsListUserIntent$2.INSTANCE);
    }

    private final void i0(d intent) {
        H().k(intent.a(), 0L, intent.b(), 104, new IOperateCallback() { // from class: com.tencent.qqnt.chats.biz.qqstranger.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                QQStrangerChatListVM.j0(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("QQStrangerChatListVM", 2, "handleStrangerChatsTopUserIntent recentContactRepo#topRecentContact result: " + i3 + ", msg: " + str);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM, com.tencent.qqnt.chats.core.mvi.a
    /* renamed from: M */
    public void l(@NotNull com.tencent.qqnt.chats.core.userintent.b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        super.l(userIntent);
        if (userIntent instanceof c) {
            h0((c) userIntent);
            return;
        }
        if (userIntent instanceof d) {
            i0((d) userIntent);
            return;
        }
        if (userIntent instanceof b) {
            H().getRecentContactList(null);
        } else if (userIntent instanceof a.k) {
            a.k kVar = (a.k) userIntent;
            ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).reportMenuOpenExpose(kVar.b(), kVar.a());
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void R(boolean isAccountChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isAccountChange);
            return;
        }
        super.R(isAccountChange);
        e.f354390a.a(this);
        ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).setTopSetUpdateListener(this);
        ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).fetchSetTopList();
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void T(boolean isAccountChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isAccountChange);
            return;
        }
        e.f354390a.c();
        ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).setTopSetUpdateListener(null);
        IKernelMsgListener D = D();
        if (D != null) {
            w e16 = f.e();
            if (e16 != null) {
                e16.removeMsgListener(D);
            }
            c0(null);
        }
        super.T(isAccountChange);
    }

    @Override // com.tencent.qqnt.chats.api.e
    public void a(@NotNull Set<String> setTops) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) setTops);
        } else {
            Intrinsics.checkNotNullParameter(setTops, "setTops");
        }
    }

    @Override // com.tencent.qqnt.chats.api.e
    public void c(@NotNull Set<String> removeSets, @NotNull Set<String> addSets) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) removeSets, (Object) addSets);
            return;
        }
        Intrinsics.checkNotNullParameter(removeSets, "removeSets");
        Intrinsics.checkNotNullParameter(addSets, "addSets");
        if (H() instanceof QQStrangerChatsRepo) {
            ((QQStrangerChatsRepo) H()).u(removeSets, addSets);
        }
    }
}

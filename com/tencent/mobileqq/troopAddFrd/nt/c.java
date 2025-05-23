package com.tencent.mobileqq.troopAddFrd.nt;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\r\u0018\u0000 \u00172\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troopAddFrd/nt/c;", "", "", "c", "d", "", "bInsert", "", "troopUin", "f", "", "state", h.F, "com/tencent/mobileqq/troopAddFrd/nt/c$b", "a", "Lcom/tencent/mobileqq/troopAddFrd/nt/c$b;", "troopObserver", "Lcom/tencent/common/app/AppInterface;", "e", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "()V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b troopObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troopAddFrd/nt/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopAddFrd.nt.c$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\bH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troopAddFrd/nt/c$b", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "isSuc", "", "troopUin", "", "type", "", "targetMemberUins", "", "onTroopBatchAddFrdsReadyForTip", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onTroopBatchAddFrdsReadyForTip(boolean isSuc, @Nullable String troopUin, int type, @Nullable List<String> targetMemberUins) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuc), troopUin, Integer.valueOf(type), targetMemberUins);
                return;
            }
            QLog.i("NtTroopObserversHelper", 1, "onTroopBatchAddFrdsReadyForTip, isSuc=" + isSuc + ", troopUin=" + troopUin + ", type=" + type);
            if (troopUin == null) {
                return;
            }
            if (type == 1 || type == 2 || type == 4) {
                c.this.f(true, troopUin);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62660);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.troopObserver = new b();
        }
    }

    private final void c() {
        AppInterface e16 = e();
        if (e16 != null) {
            e16.addObserver(this.troopObserver);
        }
    }

    private final void d() {
        AppInterface e16 = e();
        if (e16 != null) {
            e16.removeObserver(this.troopObserver);
        }
    }

    private final AppInterface e() {
        return bg.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final boolean bInsert, final String troopUin) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troopAddFrd.nt.b
            @Override // java.lang.Runnable
            public final void run() {
                c.g(bInsert, troopUin, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z16, String troopUin, c this$0) {
        ITroopBatchAddFriendService iTroopBatchAddFriendService;
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("NtTroopObserversHelper", 1, "insertTipsOrClearScene, bInsert=" + z16 + ", troopUin=" + troopUin);
        AppInterface e16 = this$0.e();
        if (e16 != null && (iTroopBatchAddFriendService = (ITroopBatchAddFriendService) e16.getRuntimeService(ITroopBatchAddFriendService.class, "")) != null) {
            if (z16) {
                iTroopBatchAddFriendService.getTroopBatchAddFriendMgr().v(troopUin);
            } else {
                iTroopBatchAddFriendService.getTroopBatchAddFriendMgr().n(troopUin);
            }
        }
    }

    public final void h(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, state);
        } else {
            if (state != 0) {
                if (state == 12) {
                    d();
                    return;
                }
                return;
            }
            c();
        }
    }
}

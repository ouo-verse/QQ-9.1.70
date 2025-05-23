package com.tencent.mobileqq.reminder.multishare.listener;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import com.tencent.state.data.SquareJSConst;
import j92.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/reminder/multishare/listener/c;", "Lj92/f;", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "callback", "", "a", "", "hasMore", "", "", "Ljava/util/List;", "getUinList", "()Ljava/util/List;", SquareJSConst.Params.PARAMS_UIN_LIST, "b", "Z", "<init>", "(Ljava/util/List;Z)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> uinList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean hasMore;

    public c(@NotNull List<String> uinList, boolean z16) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uinList, Boolean.valueOf(z16));
        } else {
            this.uinList = uinList;
            this.hasMore = z16;
        }
    }

    @Override // j92.f
    public void a(@NotNull RecentContactListener callback) {
        List<RecentUser> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.uinList.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callback.onResult(emptyList);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.uinList) {
            RecentUser recentUser = new RecentUser(str, 0);
            recentUser.displayName = str;
            arrayList.add(recentUser);
        }
        callback.onResult(arrayList);
    }

    @Override // j92.f
    public boolean hasMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.hasMore;
    }
}

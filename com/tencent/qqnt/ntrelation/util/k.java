package com.tencent.qqnt.ntrelation.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/k;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "Lkotlin/collections/ArrayList;", "ntOtherDetailInfo", "", "trace", "", "a", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f360278a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37599);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f360278a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(@NotNull ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> ntOtherDetailInfo, @Nullable String trace) {
        Object k3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntOtherDetailInfo, (Object) trace);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOtherDetailInfo, "ntOtherDetailInfo");
        if (ntOtherDetailInfo.isEmpty()) {
            return;
        }
        Iterator<com.tencent.qqnt.ntrelation.otherinfo.bean.a> it = ntOtherDetailInfo.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.a next = it.next();
            if (next != null && (k3 = FriendListInfoCache.INSTANCE.a().k(com.tencent.qqnt.contacts.cache.a.f355804a.d(), next.getUid(), trace)) != null) {
                com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = (com.tencent.qqnt.ntrelation.otherinfo.bean.c) k3;
                boolean z17 = true;
                if (next.f() != Long.MIN_VALUE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    cVar.s(next.f());
                }
                if (next.c() == Long.MIN_VALUE) {
                    z17 = false;
                }
                if (z17) {
                    cVar.p(next.c());
                }
            }
        }
    }
}

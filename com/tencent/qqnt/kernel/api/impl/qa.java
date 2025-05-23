package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.state.data.SquareJSConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\"B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 JT\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tH\u0002JT\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0003j\b\u0012\u0004\u0012\u00020\b`\u00052\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0003j\b\u0012\u0004\u0012\u00020\b`\u00052\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004`\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J(\u0010\u0017\u001a\u00020\u00162\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u001c\u001a\u00020\u00162\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0003j\b\u0012\u0004\u0012\u00020\b`\u00052\u0006\u0010\u0015\u001a\u00020\u001bH\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/qa;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/api/ag;", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", SquareJSConst.Params.PARAMS_UIN_LIST, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "result", "q4", "uidSet", "r4", "method", "", "p4", "uin", "u", "uinSet", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetUidInfoCallback;", "cb", "", "getUid", "uid", "z0", "(Ljava/lang/String;)Ljava/lang/Long;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetUinInfoCallback;", "getUin", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class qa extends BaseService<com.tencent.qqnt.kernel.api.ag, com.tencent.qqnt.kernel.api.ag> implements com.tencent.qqnt.kernel.api.ag {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/qa$a;", "", "", "LOG_TAG", "Ljava/lang/String;", "SUB_TAG", "UIX_CONVERT_CACHE_SP_NAME", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.qa$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54334);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qa(@NotNull py content) {
        super("uix_convert", content, null);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) content);
        }
    }

    private final boolean p4(String method) {
        return getContent().e().b(getSubTag(), method);
    }

    private final HashSet<Long> q4(HashSet<Long> uinList, HashMap<Long, String> result) {
        HashSet<Long> hashSet = new HashSet<>();
        Iterator<T> it = uinList.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            String u16 = u(longValue);
            if (u16 != null) {
                result.put(Long.valueOf(longValue), u16);
            } else {
                hashSet.add(Long.valueOf(longValue));
            }
        }
        return hashSet;
    }

    private final HashSet<String> r4(HashSet<String> uidSet, HashMap<String, Long> result) {
        HashSet<String> hashSet = new HashSet<>();
        for (String str : uidSet) {
            Long z06 = z0(str);
            if (z06 != null) {
                result.put(str, Long.valueOf(z06.longValue()));
            } else {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    @Override // com.tencent.qqnt.kernel.api.ag
    public void getUid(@NotNull HashSet<Long> uinSet, @NotNull IKernelGetUidInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uinSet, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(uinSet, "uinSet");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (!p4("getUid")) {
            cb5.onResult(new HashMap<>());
            return;
        }
        HashMap<Long, String> hashMap = new HashMap<>();
        if (q4(uinSet, hashMap).isEmpty()) {
            cb5.onResult(hashMap);
        } else {
            cb5.onResult(hashMap);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ag
    public void getUin(@NotNull HashSet<String> uidSet, @NotNull IKernelGetUinInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uidSet, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(uidSet, "uidSet");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (!p4("getUin")) {
            cb5.onResult(new HashMap<>());
            return;
        }
        HashMap<String, Long> hashMap = new HashMap<>();
        if (r4(uidSet, hashMap).isEmpty()) {
            cb5.onResult(hashMap);
        } else {
            cb5.onResult(hashMap);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[ORIG_RETURN, RETURN] */
    @Override // com.tencent.qqnt.kernel.api.ag
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String u(long uin) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, uin);
        }
        try {
            String uidFromUin = ((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUidFromUin(uin);
            if (uidFromUin != null) {
                if (uidFromUin.length() != 0) {
                    z16 = false;
                    if (z16) {
                        return uidFromUin;
                    }
                    return null;
                }
            }
            z16 = true;
            if (z16) {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ag
    @Nullable
    public Long z0(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uid);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        try {
            long uinFromUid = ((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUinFromUid(uid);
            if (uinFromUid != 0) {
                return Long.valueOf(uinFromUid);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

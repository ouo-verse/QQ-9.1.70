package com.tencent.qqnt.ntrelation.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.BuddyListReqType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/ntrelation/constant/a;", "", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "type", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyListReqType;", "a", "<init>", "()V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f359917a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.ntrelation.constant.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public /* synthetic */ class C9667a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359918a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37279);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[RelationListReqType.values().length];
            try {
                iArr[RelationListReqType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RelationListReqType.LETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f359918a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f359917a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final BuddyListReqType a(@NotNull RelationListReqType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BuddyListReqType) iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = C9667a.f359918a[type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return BuddyListReqType.KLETTER;
            }
            throw new NoWhenBranchMatchedException();
        }
        return BuddyListReqType.KNOMAL;
    }
}

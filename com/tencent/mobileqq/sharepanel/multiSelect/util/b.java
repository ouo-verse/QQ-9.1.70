package com.tencent.mobileqq.sharepanel.multiSelect.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/util/b;", "", "", "uin", "", "uinType", "a", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f287481a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f287481a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a(@NotNull String uin, int uinType) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, uinType)).intValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (uinType == 0) {
            return 1;
        }
        if (uinType != 1) {
            if (uinType == 1000 || uinType == 1004 || uinType == 1006) {
                return 1;
            }
            if (uinType != 3000) {
                if (uinType == 6000) {
                    return -1;
                }
                if (uinType == 10008 || uinType == 10010) {
                    return 1;
                }
                return -1;
            }
            return 101;
        }
        if (!((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(uin)) {
            i3 = 113;
        } else {
            i3 = 4;
        }
        return i3;
    }
}

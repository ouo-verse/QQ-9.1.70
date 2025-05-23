package com.tencent.qqnt.ntrelation.util;

import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/a;", "", "T", StepCounterConstants.BEACON_PARAM_KEY_DATA1, StepCounterConstants.BEACON_PARAM_KEY_DATA2, "", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", "b", "<init>", "()V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360228a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37617);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f360228a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final <T> boolean a(@Nullable T data1, @Nullable T data2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) data1, (Object) data2)).booleanValue();
        }
        if (data1 == null && data2 == null) {
            return true;
        }
        if (data1 == null || data2 == null) {
            return false;
        }
        return Intrinsics.areEqual(data1, data2);
    }

    public final boolean b(@Nullable byte[] data1, @Nullable byte[] data2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data1, (Object) data2)).booleanValue();
        }
        if (data1 == null && data2 == null) {
            return true;
        }
        if (data1 == null || data2 == null) {
            return false;
        }
        return Arrays.equals(data1, data2);
    }
}

package com.tencent.aio.main.businesshelper.old;

import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f69375a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[Lifecycle.Event.values().length];
        f69375a = iArr;
        iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
    }
}

package com.tencent.mobileqq.matchfriend.reborn.couple.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0003\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/b;", "", "", "b", "I", "BIZ_ID_START", "c", "()I", "BIZ_ID_QQ_STRANGER", "d", "a", "BIZ_ID_NEARBY_RPO", "<init>", "()V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f245072a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int BIZ_ID_START;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int BIZ_ID_QQ_STRANGER;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int BIZ_ID_NEARBY_RPO;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23620);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f245072a = new b();
        int i3 = 1000 + 1;
        BIZ_ID_QQ_STRANGER = 1000;
        BIZ_ID_START = i3 + 1;
        BIZ_ID_NEARBY_RPO = i3;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return BIZ_ID_NEARBY_RPO;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return BIZ_ID_QQ_STRANGER;
    }
}

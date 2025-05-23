package com.tencent.mobileqq.groupvideo.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "GVTAG", "group-video-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f213753a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23704);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f213753a = "GV_tag.";
        }
    }

    @NotNull
    public static final String a() {
        return f213753a;
    }
}

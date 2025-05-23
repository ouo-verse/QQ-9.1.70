package com.tencent.mobileqq.qqlive.framework.eventbroadcaster;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000b\"\u0004\b\t\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "", "", "a", "J", "getCreateTime", "()J", WadlProxyConsts.CREATE_TIME, "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/l;", "b", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/l;", "()Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/l;", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/l;)V", "tag", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long createTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private l tag;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.createTime = System.currentTimeMillis();
        }
    }

    @Nullable
    public final l a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (l) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.tag;
    }

    public final void b(@Nullable l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) lVar);
        } else {
            this.tag = lVar;
        }
    }
}

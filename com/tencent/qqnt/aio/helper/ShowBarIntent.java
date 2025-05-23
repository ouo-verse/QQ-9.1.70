package com.tencent.qqnt.aio.helper;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@AutoEventName
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ShowBarIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "Lcom/tencent/qqnt/aio/helper/bd;", "d", "Lcom/tencent/qqnt/aio/helper/bd;", "a", "()Lcom/tencent/qqnt/aio/helper/bd;", "bar", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ShowBarIntent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bd bar;

    @NotNull
    public final bd a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (bd) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bar;
    }

    @Override // com.tencent.mvi.base.route.i
    public String eventName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "com.tencent.qqnt.aio.helper.ShowBarIntent";
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }
}

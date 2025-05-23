package com.tencent.mobileqq.aio.lateinit;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0001\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/lateinit/LatinitCreateModeIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "childVm", "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "a", "()Lcom/tencent/mvi/base/route/MsgIntent;", "childInitMsgIntent", "<init>", "(Ljava/lang/String;Lcom/tencent/mvi/base/route/MsgIntent;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class LatinitCreateModeIntent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String childVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgIntent childInitMsgIntent;

    public LatinitCreateModeIntent(@NotNull String childVm, @NotNull MsgIntent childInitMsgIntent) {
        Intrinsics.checkNotNullParameter(childVm, "childVm");
        Intrinsics.checkNotNullParameter(childInitMsgIntent, "childInitMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) childVm, (Object) childInitMsgIntent);
        } else {
            this.childVm = childVm;
            this.childInitMsgIntent = childInitMsgIntent;
        }
    }

    @NotNull
    public final MsgIntent a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgIntent) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.childInitMsgIntent;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.childVm;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }
}

package com.tencent.qqnt.ntrelation.friendsinfo.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/i;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", WebViewPlugin.KEY_RESPONSE, "", "b", "", "a", "Ljava/lang/String;", "getTrace", "()Ljava/lang/String;", "trace", "Lhx3/b;", "Lhx3/b;", "()Lhx3/b;", "callback", "<init>", "(Ljava/lang/String;Lhx3/b;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String trace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> callback;

    public i(@Nullable String str, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) callback);
        } else {
            this.trace = str;
            this.callback = callback;
        }
    }

    @NotNull
    public final hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (hx3.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.callback;
    }

    public final void b(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> responseData) {
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) responseData);
            return;
        }
        hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> bVar = this.callback;
        if (bVar != null) {
            bVar.onQueryResult(responseData);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.util.a aVar = com.tencent.qqnt.ntrelation.friendsinfo.util.a.f360077a;
        String str = this.trace;
        if (responseData != null) {
            arrayList = responseData.b();
        } else {
            arrayList = null;
        }
        aVar.b(str, arrayList);
    }
}

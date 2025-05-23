package com.tencent.qqnt.ntrelation.otherinfo.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\r\u0010\u000bR#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/bean/b;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", WebViewPlugin.KEY_RESPONSE, "", "b", "", "a", "Ljava/lang/String;", "getUid", "()Ljava/lang/String;", "uid", "getTrace", "trace", "Ljava/lang/ref/WeakReference;", "Lhx3/b;", "c", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "callback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String trace;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<hx3.b<a>> callback;

    public b(@NotNull String uid, @Nullable String str, @NotNull WeakReference<hx3.b<a>> callback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uid, str, callback);
            return;
        }
        this.uid = uid;
        this.trace = str;
        this.callback = callback;
    }

    @NotNull
    public final WeakReference<hx3.b<a>> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (WeakReference) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.callback;
    }

    public final void b(@Nullable e<a> responseData) {
        ArrayList<a> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) responseData);
            return;
        }
        hx3.b<a> bVar = this.callback.get();
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
        aVar.g(str, arrayList);
    }
}

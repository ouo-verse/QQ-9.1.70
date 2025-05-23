package com.tencent.qqnt.ntrelation.friendsinfo.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/j;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", "", WebViewPlugin.KEY_RESPONSE, "", "b", "a", "Ljava/lang/String;", "getTrace", "()Ljava/lang/String;", "trace", "Ljava/lang/ref/WeakReference;", "Lhx3/b;", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "callback", "<init>", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String trace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<hx3.b<String>> callback;

    public j(@Nullable String str, @NotNull WeakReference<hx3.b<String>> callback) {
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
    public final WeakReference<hx3.b<String>> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WeakReference) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.callback;
    }

    public final void b(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<String> responseData) {
        String str;
        ArrayList<String> b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) responseData);
            return;
        }
        hx3.b<String> bVar = this.callback.get();
        if (bVar != null) {
            bVar.onQueryResult(responseData);
        }
        if (responseData != null && (b16 = responseData.b()) != null) {
            str = b16.toString();
        } else {
            str = null;
        }
        QLog.i("FriendsInfoLogUtil", 1, "NTChangeedFriendUidsObserver changed uids: " + str);
    }
}

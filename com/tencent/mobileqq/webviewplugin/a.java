package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u43.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/webviewplugin/a;", "", "", "c", "Landroid/app/Activity;", "a", "Lu43/a$a;", "Lu43/a$a;", "getCallback", "()Lu43/a$a;", IECSearchBar.METHOD_SET_CALLBACK, "(Lu43/a$a;)V", "callback", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "url", "<init>", "(Ljava/lang/String;Lu43/a$a;)V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a.InterfaceC11322a callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String url;

    public a(String url, a.InterfaceC11322a interfaceC11322a) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.callback = interfaceC11322a;
        this.url = url;
    }

    public Activity a() {
        a.InterfaceC11322a interfaceC11322a = this.callback;
        if (interfaceC11322a != null) {
            return interfaceC11322a.getActivity();
        }
        return null;
    }

    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public void c() {
        a.InterfaceC11322a interfaceC11322a = this.callback;
        if (interfaceC11322a != null) {
            interfaceC11322a.resume();
        }
    }
}

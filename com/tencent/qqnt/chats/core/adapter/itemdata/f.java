package com.tencent.qqnt.chats.core.adapter.itemdata;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.j;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.m;
import com.tencent.qqnt.chats.data.converter.k;
import com.tencent.qqnt.chats.data.converter.l;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J%\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/f;", "", "payload", "Lcom/tencent/qqnt/chats/data/converter/f;", "a", "", "payloads", "b", "([Ljava/lang/Object;)[Lcom/tencent/qqnt/chats/data/converter/f;", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f354528a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42480);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f354528a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.qqnt.chats.data.converter.f a(@Nullable Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.data.converter.f) iPatchRedirector.redirect((short) 2, (Object) this, payload);
        }
        if (payload instanceof j) {
            return k.f355124a;
        }
        if (payload instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.i) {
            return com.tencent.qqnt.chats.data.converter.j.f355123a;
        }
        if (payload instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.h) {
            return com.tencent.qqnt.chats.data.converter.i.f355122a;
        }
        if (payload instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.a) {
            return com.tencent.qqnt.chats.data.converter.a.f355110a;
        }
        if (payload instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.e) {
            return com.tencent.qqnt.chats.data.converter.h.f355121a;
        }
        if (payload instanceof m) {
            return com.tencent.qqnt.chats.data.converter.m.f355126a;
        }
        if (payload instanceof com.tencent.qqnt.chats.core.adapter.itemdata.payload.c) {
            return com.tencent.qqnt.chats.data.converter.d.f355120a;
        }
        return l.f355125a;
    }

    @Nullable
    public final com.tencent.qqnt.chats.data.converter.f[] b(@Nullable Object[] payloads) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.data.converter.f[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) payloads);
        }
        boolean z17 = true;
        if (payloads != null) {
            if (payloads.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = false;
            }
        }
        if (z17) {
            return null;
        }
        ArrayList arrayList = new ArrayList(payloads.length);
        for (Object obj : payloads) {
            arrayList.add(f354528a.a(obj));
        }
        Object[] array = arrayList.toArray(new com.tencent.qqnt.chats.data.converter.f[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.tencent.qqnt.chats.data.converter.f[]) array;
    }
}

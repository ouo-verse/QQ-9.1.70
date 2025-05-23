package com.tencent.qqnt.avatar.core;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.fetch.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH&J\u001c\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH&R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/avatar/core/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/avatar/bean/a;", "bean", "Lcom/tencent/qqnt/avatar/core/a$a;", "callback", "", "forceRefresh", "Lcom/tencent/qqnt/avatar/fetch/b;", "a", "Lcom/tencent/qqnt/avatar/fetch/d;", "c", "", "I", "getFetcherType", "()I", "fetcherType", "<init>", "(I)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int fetcherType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/avatar/core/a$a;", "", "Lcom/tencent/qqnt/avatar/fetch/d;", "result", "", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC9507a {
        void a(@NotNull d result);
    }

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.fetcherType = i3;
        }
    }

    public static /* synthetic */ com.tencent.qqnt.avatar.fetch.b b(a aVar, Context context, com.tencent.qqnt.avatar.bean.a aVar2, InterfaceC9507a interfaceC9507a, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 8) != 0) {
                z16 = false;
            }
            return aVar.a(context, aVar2, interfaceC9507a, z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetcherResource");
    }

    public static /* synthetic */ d d(a aVar, com.tencent.qqnt.avatar.bean.a aVar2, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            return aVar.c(aVar2, z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncFetcherResource");
    }

    @NotNull
    public abstract com.tencent.qqnt.avatar.fetch.b a(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.bean.a bean, @NotNull InterfaceC9507a callback, boolean forceRefresh);

    @Nullable
    public abstract d c(@NotNull com.tencent.qqnt.avatar.bean.a bean, boolean forceRefresh);
}

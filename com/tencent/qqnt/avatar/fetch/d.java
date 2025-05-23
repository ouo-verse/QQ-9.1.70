package com.tencent.qqnt.avatar.fetch;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR!\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\b\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/avatar/fetch/d;", "", "Lcom/tencent/qqnt/avatar/bean/a;", "a", "Lcom/tencent/qqnt/avatar/bean/a;", "()Lcom/tencent/qqnt/avatar/bean/a;", "bean", "", "b", "Z", "c", "()Z", "isSuccess", "Lcom/tencent/qqnt/avatar/layer/d;", "Lcom/tencent/qqnt/avatar/layer/d;", "()Lcom/tencent/qqnt/avatar/layer/d;", "resourceLayer", "", "d", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "errorMsg", "<init>", "(Lcom/tencent/qqnt/avatar/bean/a;ZLcom/tencent/qqnt/avatar/layer/d;Ljava/lang/String;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.bean.a bean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isSuccess;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.avatar.layer.d<? extends Object> resourceLayer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errorMsg;

    public d(@NotNull com.tencent.qqnt.avatar.bean.a bean, boolean z16, @Nullable com.tencent.qqnt.avatar.layer.d<? extends Object> dVar, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bean, Boolean.valueOf(z16), dVar, str);
            return;
        }
        this.bean = bean;
        this.isSuccess = z16;
        this.resourceLayer = dVar;
        this.errorMsg = str;
    }

    @NotNull
    public final com.tencent.qqnt.avatar.bean.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.avatar.bean.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.bean;
    }

    @Nullable
    public final com.tencent.qqnt.avatar.layer.d<? extends Object> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.avatar.layer.d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.resourceLayer;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isSuccess;
    }

    public /* synthetic */ d(com.tencent.qqnt.avatar.bean.a aVar, boolean z16, com.tencent.qqnt.avatar.layer.d dVar, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i3 & 2) != 0 ? true : z16, (i3 & 4) != 0 ? null : dVar, (i3 & 8) == 0 ? str : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aVar, Boolean.valueOf(z16), dVar, str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

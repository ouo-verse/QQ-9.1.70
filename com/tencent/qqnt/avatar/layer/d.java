package com.tencent.qqnt.avatar.layer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\f\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0004\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/avatar/layer/d;", "T", "", "Lcom/tencent/qqnt/avatar/bean/a;", "a", "Lcom/tencent/qqnt/avatar/bean/a;", "b", "()Lcom/tencent/qqnt/avatar/bean/a;", "bean", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "resource", "Lcom/tencent/qqnt/avatar/layer/c;", "c", "Lcom/tencent/qqnt/avatar/layer/c;", "()Lcom/tencent/qqnt/avatar/layer/c;", "drawConfig", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "[Lcom/tencent/qqnt/avatar/meta/info/a;", "()[Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfoArray", "<init>", "(Lcom/tencent/qqnt/avatar/bean/a;Ljava/lang/Object;Lcom/tencent/qqnt/avatar/layer/c;[Lcom/tencent/qqnt/avatar/meta/info/a;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class d<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.bean.a bean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final T resource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c drawConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArray;

    public d(@NotNull com.tencent.qqnt.avatar.bean.a bean, T t16, @Nullable c cVar, @Nullable com.tencent.qqnt.avatar.meta.info.a[] aVarArr) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bean, t16, cVar, aVarArr);
            return;
        }
        this.bean = bean;
        this.resource = t16;
        this.drawConfig = cVar;
        this.avatarInfoArray = aVarArr;
    }

    @Nullable
    public final com.tencent.qqnt.avatar.meta.info.a[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.avatar.meta.info.a[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.avatarInfoArray;
    }

    @NotNull
    public final com.tencent.qqnt.avatar.bean.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.avatar.bean.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.bean;
    }

    @Nullable
    public final c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.drawConfig;
    }

    public final T d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.resource;
    }

    public /* synthetic */ d(com.tencent.qqnt.avatar.bean.a aVar, Object obj, c cVar, com.tencent.qqnt.avatar.meta.info.a[] aVarArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, obj, (i3 & 4) != 0 ? null : cVar, (i3 & 8) == 0 ? aVarArr : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aVar, obj, cVar, aVarArr, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

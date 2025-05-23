package com.tencent.aio.part.root.panel.mvx.config;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/aio/part/root/panel/mvx/config/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/aio/data/AIOParam;", "a", "Lcom/tencent/aio/data/AIOParam;", "b", "()Lcom/tencent/aio/data/AIOParam;", "mAIOParam", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "<init>", "(Lcom/tencent/aio/data/AIOParam;Lcom/tencent/aio/api/runtime/a;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOParam mAIOParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    public c(@NotNull AIOParam mAIOParam, @NotNull com.tencent.aio.api.runtime.a mAIOContext) {
        Intrinsics.checkNotNullParameter(mAIOParam, "mAIOParam");
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mAIOParam, (Object) mAIOContext);
        } else {
            this.mAIOParam = mAIOParam;
            this.mAIOContext = mAIOContext;
        }
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mAIOContext;
    }

    @NotNull
    public final AIOParam b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AIOParam) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mAIOParam;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof c) {
                c cVar = (c) other;
                if (!Intrinsics.areEqual(this.mAIOParam, cVar.mAIOParam) || !Intrinsics.areEqual(this.mAIOContext, cVar.mAIOContext)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        AIOParam aIOParam = this.mAIOParam;
        int i16 = 0;
        if (aIOParam != null) {
            i3 = aIOParam.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null) {
            i16 = aVar.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "PanelParam(mAIOParam=" + this.mAIOParam + ", mAIOContext=" + this.mAIOContext + ")";
    }
}

package com.tencent.mobileqq.pic.picloader;

import android.graphics.Bitmap;
import com.tencent.cache.api.e;
import com.tencent.libra.cache.EngineResource;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/pic/picloader/a;", "Z", "Lcom/tencent/cache/api/e;", "Landroid/graphics/Bitmap;", "getBitmap", "", "getByteSize", "", "toString", "Lcom/tencent/libra/cache/EngineResource;", "d", "Lcom/tencent/libra/cache/EngineResource;", "a", "()Lcom/tencent/libra/cache/EngineResource;", "engineResource", "<init>", "(Lcom/tencent/libra/cache/EngineResource;)V", "pic_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a<Z> implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EngineResource<Z> engineResource;

    public a(@NotNull EngineResource<Z> engineResource) {
        Intrinsics.checkNotNullParameter(engineResource, "engineResource");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) engineResource);
        } else {
            this.engineResource = engineResource;
        }
    }

    @NotNull
    public final EngineResource<Z> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EngineResource) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.engineResource;
    }

    @Override // com.tencent.cache.api.e
    @Nullable
    public Bitmap getBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Z z16 = this.engineResource.get();
        if (z16 instanceof Bitmap) {
            return (Bitmap) z16;
        }
        return null;
    }

    @Override // com.tencent.cache.api.f
    public int getByteSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.engineResource.getSize();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "QQEngineResourceAdapter{mEngineResource=" + this.engineResource + "}";
    }
}

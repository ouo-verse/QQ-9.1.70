package com.tencent.aio.runtime.emitter;

import com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack;
import com.tencent.aio.api.runtime.emitter.c;
import com.tencent.aio.api.runtime.emitter.d;
import com.tencent.aio.part.root.panel.mvx.service.PanelStateServiceEmitter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ml3.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J#\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ/\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0000\u00a2\u0006\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/aio/runtime/emitter/a;", "Lml3/b;", "T", "Ljava/lang/Class;", "clazz", "Lml3/a;", "a", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/tencent/aio/runtime/emitter/AIOFunctionEmitter;", "emitter", "", "c", "(Ljava/lang/Class;Lcom/tencent/aio/runtime/emitter/AIOFunctionEmitter;)V", "", "Ljava/util/Map;", "servicePool", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Class<?>, AIOFunctionEmitter<?>> servicePool;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.servicePool = linkedHashMap;
        linkedHashMap.put(com.tencent.aio.api.runtime.emitter.b.class, new ConfigurationEmitter());
        linkedHashMap.put(com.tencent.aio.api.runtime.emitter.a.class, new BackEventEmitter());
        linkedHashMap.put(d.class, new PictureInPictureModeChangedEmitter());
        linkedHashMap.put(c.class, new MultiWindowModeChangedEmitter());
        linkedHashMap.put(AIOServiceContact$IRecycleViewScrollCallBack.class, new RecycleViewScrollEmitter());
        linkedHashMap.put(com.tencent.aio.part.root.panel.mvx.service.a.class, new PanelStateServiceEmitter());
    }

    @Override // ml3.b
    @NotNull
    public <T> ml3.a<T> a(@NotNull Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ml3.a) iPatchRedirector.redirect((short) 1, (Object) this, (Object) clazz);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        AIOFunctionEmitter<?> aIOFunctionEmitter = this.servicePool.get(clazz);
        if (aIOFunctionEmitter != null) {
            return aIOFunctionEmitter;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.api.business.IEmitterRegister<T>");
    }

    @Override // ml3.b
    public <T> T b(@NotNull Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.servicePool.get(clazz);
    }

    public final <T> void c(@NotNull Class<T> clazz, @NotNull AIOFunctionEmitter<?> emitter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) clazz, (Object) emitter);
            return;
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        this.servicePool.put(clazz, emitter);
    }
}

package com.tencent.mvi.mvvm.extension;

import androidx.annotation.MainThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\tH\u0007J\u001f\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fR4\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mvi/mvvm/extension/d;", "", "T", "", "key", "newValue", "d", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "obj", "", "b", "Lkotlinx/coroutines/CoroutineScope;", "e", "a", "c", "(Ljava/lang/String;)Ljava/lang/Object;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mBagOfTags", "", "Z", "mCleared", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Object> mBagOfTags;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mCleared;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mBagOfTags = new HashMap<>();
        }
    }

    private final void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e16) {
                throw new RuntimeException(e16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T d(String key, T newValue) {
        Object obj;
        HashMap<String, Object> hashMap = this.mBagOfTags;
        Intrinsics.checkNotNull(hashMap);
        synchronized (hashMap) {
            HashMap<String, Object> hashMap2 = this.mBagOfTags;
            Intrinsics.checkNotNull(key);
            obj = hashMap2.get(key);
            if (obj == 0) {
                this.mBagOfTags.put(key, newValue);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (obj != 0) {
            newValue = obj;
        }
        if (this.mCleared) {
            b(newValue);
        }
        return newValue;
    }

    @MainThread
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mCleared = true;
        HashMap<String, Object> hashMap = this.mBagOfTags;
        if (hashMap != null) {
            synchronized (hashMap) {
                Iterator<Object> it = this.mBagOfTags.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Nullable
    public final <T> T c(@Nullable String key) {
        T t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) key);
        }
        HashMap<String, Object> hashMap = this.mBagOfTags;
        if (hashMap == null) {
            return null;
        }
        synchronized (hashMap) {
            t16 = (T) this.mBagOfTags.get(key);
        }
        return t16;
    }

    @NotNull
    public final CoroutineScope e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        CoroutineScope coroutineScope = (CoroutineScope) c("com.tencent.mvi.vm.JOB_KEY");
        if (coroutineScope != null) {
            return coroutineScope;
        }
        return (CoroutineScope) d("com.tencent.mvi.vm.JOB_KEY", new a(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate())));
    }
}

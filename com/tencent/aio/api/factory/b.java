package com.tencent.aio.api.factory;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/api/factory/b;", "", "b", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, g> f69120a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R0\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/api/factory/b$a;", "", "Lcom/tencent/aio/api/factory/g;", "factory", "", "a", "", "name", "b", "(Ljava/lang/String;)Lcom/tencent/aio/api/factory/g;", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mFactoryMap", "Ljava/util/HashMap;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.api.factory.b$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Deprecated(message = "\u4e1a\u52a1\u65e0\u9700\u8c03\u7528\u6b64\u65b9\u6cd5\uff0c\u540e\u7eed\u4f1a\u5c4f\u853d\uff0c\u8bf7\u8c03\u7528\u8005 \u5220\u9664\u9002\u914d")
        public final void a(@NotNull g factory) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) factory);
                return;
            }
            Intrinsics.checkNotNullParameter(factory, "factory");
            HashMap hashMap = b.f69120a;
            String name = factory.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "factory.javaClass.name");
            hashMap.put(name, factory);
        }

        @Nullable
        public final g b(@Nullable String name) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (g) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name);
            }
            if (!TextUtils.isEmpty(name)) {
                HashMap hashMap = b.f69120a;
                if (hashMap != null) {
                    if (!hashMap.containsKey(name)) {
                        Intrinsics.checkNotNull(name);
                        Object newInstance = Class.forName(name).newInstance();
                        if (newInstance instanceof g) {
                            b.f69120a.put(name, newInstance);
                        }
                    }
                    return (g) b.f69120a.get(name);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            return null;
        }

        public final void c(@NotNull String name) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) name);
            } else {
                Intrinsics.checkNotNullParameter(name, "name");
                b.f69120a.remove(name);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17066);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
            f69120a = new HashMap<>();
        }
    }
}

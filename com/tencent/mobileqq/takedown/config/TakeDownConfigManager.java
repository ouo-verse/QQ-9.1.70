package com.tencent.mobileqq.takedown.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.vivo.push.PushClientConstants;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/takedown/config/TakeDownConfigManager;", "", "", PushClientConstants.TAG_CLASS_NAME, "methodName", "args", "returnType", "", "b", "Lcom/tencent/mobileqq/takedown/config/TakeDownConfigManager$a;", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/takedown/config/TakeDownConfigManager$a;", "getConfig", "<init>", "()V", "code_takedown_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TakeDownConfigManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TakeDownConfigManager f291393a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy getConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/takedown/config/TakeDownConfigManager$a;", "Lcom/tencent/freesia/IConfigData;", "", "", "", "d", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "whiteList", "<init>", "(Ljava/util/Map;)V", "code_takedown_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements IConfigData {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, Boolean> whiteList;

        public a() {
            this(null, 1, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @NotNull
        public final Map<String, Boolean> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.whiteList;
        }

        public a(@NotNull Map<String, Boolean> whiteList) {
            Intrinsics.checkNotNullParameter(whiteList, "whiteList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.whiteList = whiteList;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) whiteList);
            }
        }

        public /* synthetic */ a(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? MapsKt__MapsKt.emptyMap() : map);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, map, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35919);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f291393a = new TakeDownConfigManager();
        lazy = LazyKt__LazyJVMKt.lazy(TakeDownConfigManager$getConfig$2.INSTANCE);
        getConfig = lazy;
    }

    TakeDownConfigManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (a) getConfig.getValue();
    }

    public final boolean b(@NotNull String className, @NotNull String methodName, @NotNull String args, @NotNull String returnType) {
        Map<String, Boolean> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, className, methodName, args, returnType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        a a17 = a();
        if (a17 != null && (a16 = a17.a()) != null) {
            z16 = Intrinsics.areEqual(a16.get(className + '#' + methodName + '#' + args + '#' + returnType), Boolean.FALSE);
        }
        return !z16;
    }
}

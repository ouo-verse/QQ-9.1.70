package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IHelperProviderCompose;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011JO\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJO\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0004\"\u00020\rH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/HelperProviderComposeImpl;", "Lcom/tencent/qqnt/aio/api/IHelperProviderCompose;", "Lcom/tencent/aio/api/help/a;", "param", "", "Lcom/tencent/aio/main/businesshelper/h;", "helpers", "extHelpers", "", "", "Lkotlin/Function0;", "composeLifecycleHelpers", "(Lcom/tencent/aio/api/help/a;[Lcom/tencent/aio/main/businesshelper/h;[Lcom/tencent/aio/main/businesshelper/h;)Ljava/util/Map;", "Lcom/tencent/aio/main/businesshelper/e;", "composeAllNormalHelpers", "(Lcom/tencent/aio/api/help/a;[Lcom/tencent/aio/main/businesshelper/e;[Lcom/tencent/aio/main/businesshelper/e;)Ljava/util/Map;", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class HelperProviderComposeImpl implements IHelperProviderCompose {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "HelperProviderComposeImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/HelperProviderComposeImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.HelperProviderComposeImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65493);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HelperProviderComposeImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IHelperProviderCompose
    @Nullable
    public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> composeAllNormalHelpers(@NotNull com.tencent.aio.api.help.a param, @Nullable com.tencent.aio.main.businesshelper.e[] helpers, @NotNull com.tencent.aio.main.businesshelper.e... extHelpers) {
        com.tencent.aio.main.businesshelper.e[] eVarArr;
        Object[] plus;
        int mapCapacity;
        int coerceAtLeast;
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, this, param, helpers, extHelpers);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(extHelpers, "extHelpers");
        com.tencent.aio.api.help.d a16 = com.tencent.mobileqq.aio.helper.g.f189049a.a(param);
        if (a16 != null) {
            eVarArr = a16.getNormalHelper();
        } else {
            eVarArr = null;
        }
        Object[] objArr = new com.tencent.aio.main.businesshelper.e[0];
        if (helpers != null) {
            objArr = ArraysKt___ArraysJvmKt.plus(objArr, (Object[]) helpers);
        }
        plus = ArraysKt___ArraysJvmKt.plus(objArr, (Object[]) extHelpers);
        if (eVarArr != null) {
            plus = ArraysKt___ArraysJvmKt.plus(plus, (Object[]) eVarArr);
        }
        if (QLog.isColorLevel()) {
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(plus, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, HelperProviderComposeImpl$composeAllNormalHelpers$3.INSTANCE, 31, (Object) null);
            QLog.d(TAG, 1, "composeNormalHelpers: " + joinToString$default);
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(plus.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : plus) {
            final com.tencent.aio.main.businesshelper.e eVar = (com.tencent.aio.main.businesshelper.e) obj;
            Pair pair = TuplesKt.to(String.valueOf(eVar.getId()), new Function0<com.tencent.aio.main.businesshelper.e>() { // from class: com.tencent.qqnt.aio.api.impl.HelperProviderComposeImpl$composeAllNormalHelpers$4$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.aio.main.businesshelper.e.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.e invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.aio.main.businesshelper.e.this : (com.tencent.aio.main.businesshelper.e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @Override // com.tencent.qqnt.aio.api.IHelperProviderCompose
    @Nullable
    public Map<String, Function0<com.tencent.aio.main.businesshelper.h>> composeLifecycleHelpers(@NotNull com.tencent.aio.api.help.a param, @Nullable com.tencent.aio.main.businesshelper.h[] helpers, @NotNull com.tencent.aio.main.businesshelper.h... extHelpers) {
        com.tencent.aio.main.businesshelper.h[] hVarArr;
        Object[] plus;
        int mapCapacity;
        int coerceAtLeast;
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, this, param, helpers, extHelpers);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(extHelpers, "extHelpers");
        com.tencent.aio.api.help.d a16 = com.tencent.mobileqq.aio.helper.g.f189049a.a(param);
        if (a16 != null) {
            hVarArr = a16.getLifeCycleHelper();
        } else {
            hVarArr = null;
        }
        Object[] objArr = new com.tencent.aio.main.businesshelper.h[0];
        if (helpers != null) {
            objArr = ArraysKt___ArraysJvmKt.plus(objArr, (Object[]) helpers);
        }
        plus = ArraysKt___ArraysJvmKt.plus(objArr, (Object[]) extHelpers);
        if (hVarArr != null) {
            plus = ArraysKt___ArraysJvmKt.plus(plus, (Object[]) hVarArr);
        }
        if (QLog.isColorLevel() && hVarArr != null) {
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(plus, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, HelperProviderComposeImpl$composeLifecycleHelpers$3.INSTANCE, 31, (Object) null);
            QLog.d(TAG, 1, "composeLifecycleHelpers: " + joinToString$default);
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(plus.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : plus) {
            final com.tencent.aio.main.businesshelper.h hVar = (com.tencent.aio.main.businesshelper.h) obj;
            Pair pair = TuplesKt.to(String.valueOf(hVar.getId()), new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.api.impl.HelperProviderComposeImpl$composeLifecycleHelpers$4$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.aio.main.businesshelper.h.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.aio.main.businesshelper.h.this : (com.tencent.aio.main.businesshelper.h) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}

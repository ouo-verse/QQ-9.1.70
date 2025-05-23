package com.tencent.mobileqq.nearbypro.base.config;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest;
import com.tencent.mobileqq.util.SSODebugUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\u001a\u001d\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004\"\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"T", "t", "", "b", "(Ljava/lang/Object;)Ljava/lang/String;", "c", "", "a", "Z", "getNearbyDebugBuf", "()Z", "setNearbyDebugBuf", "(Z)V", "nearbyDebugBuf", "Ljava/lang/String;", "getDebugEnv", "()Ljava/lang/String;", "setDebugEnv", "(Ljava/lang/String;)V", "debugEnv", "qq_nearby_pro_base_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProNetworkHelperImplKt {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f253219a = c.a.a(j.d(), "nearby_pro_config", false, null, false, 12, null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static String f253220b;

    static {
        String joinToString$default;
        String[] loadTestEnvironment = SSODebugUtil.loadTestEnvironment();
        Intrinsics.checkNotNullExpressionValue(loadTestEnvironment, "loadTestEnvironment()");
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(loadTestEnvironment, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.nearbypro.base.config.NearbyProNetworkHelperImplKt$debugEnv$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(String it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                return it;
            }
        }, 31, (Object) null);
        f253220b = joinToString$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String b(T t16) {
        if (j.a().mo208public()) {
            return "";
        }
        return f253220b + c(t16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> String c(T t16) {
        String valueOf;
        if (!f253219a) {
            return "";
        }
        if (t16 instanceof MessageNano) {
            valueOf = com.tencent.mobileqq.nearbypro.request.c.d((MessageNano) t16);
        } else if (t16 instanceof NearbyProBasePBRequest) {
            valueOf = com.tencent.mobileqq.nearbypro.request.c.d(((NearbyProBasePBRequest) t16).getPbReq());
        } else {
            valueOf = String.valueOf(t16);
        }
        return " " + valueOf;
    }
}

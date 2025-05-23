package com.tencent.mobileqq.config.business.qmmkv;

import com.tencent.mobileqq.qmmkv.MMKVWithAccountDeleteConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/MMKVCacheConfig;", "Lcom/tencent/mobileqq/qmmkv/d;", "", "d", "", "", "b", "a", "", "", "c", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class MMKVCacheConfig implements com.tencent.mobileqq.qmmkv.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f202795b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/MMKVCacheConfig$a;", "", "", "isHighLevelFd$delegate", "Lkotlin/Lazy;", "b", "()Z", "isHighLevelFd", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.qmmkv.MMKVCacheConfig$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) MMKVCacheConfig.f202795b.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.config.business.qmmkv.MMKVCacheConfig$Companion$isHighLevelFd$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(g.f202811f.b());
            }
        });
        f202795b = lazy;
    }

    @Override // com.tencent.mobileqq.qmmkv.d
    public boolean a() {
        return MMKVWithAccountDeleteConfig.INSTANCE.a().getSwitchOn();
    }

    @Override // com.tencent.mobileqq.qmmkv.d
    @NotNull
    public Map<Integer, Integer> b() {
        HashMap hashMapOf;
        int c16 = f.f202810f.c();
        int i3 = c16 >>> 24;
        int i16 = (c16 >>> 16) & 255;
        int i17 = (c16 >>> 8) & 255;
        int i18 = c16 & 255;
        QLog.d("QMMKV_cache_MMKVCacheConfig", 1, "getMaxCacheCountMap value: " + c16 + " [" + i3 + ", " + i16 + ", " + i17 + ", " + i18 + "]");
        if (i3 <= 0) {
            i3 = 4;
        }
        if (i16 <= 0) {
            i16 = 8;
        }
        if (i17 <= 0) {
            i17 = 6;
        }
        if (i18 <= 0) {
            i18 = 6;
        }
        if (INSTANCE.b()) {
            i3 = (int) (i3 * 2.0f);
            i16 = (int) (i16 * 2.0f);
            i17 = (int) (i17 * 2.0f);
            i18 = (int) (i18 * 2.0f);
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, Integer.valueOf(i3)), TuplesKt.to(2, Integer.valueOf(i16)), TuplesKt.to(4, Integer.valueOf(i17)), TuplesKt.to(8, Integer.valueOf(i18)));
        return hashMapOf;
    }

    @Override // com.tencent.mobileqq.qmmkv.d
    @NotNull
    public List<String> c() {
        return MMKVWithAccountDeleteConfig.INSTANCE.a().c();
    }

    @Override // com.tencent.mobileqq.qmmkv.d
    public boolean d() {
        b bVar;
        Companion companion = INSTANCE;
        if (companion.b()) {
            bVar = d.f202808f;
        } else {
            bVar = e.f202809f;
        }
        boolean b16 = bVar.b();
        QLog.d("QMMKV_cache_MMKVCacheConfig", 1, "getMMKVAutoCloseSwitch: " + b16 + " isHighLevelFd: " + companion.b());
        return b16;
    }
}

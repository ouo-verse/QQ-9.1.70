package com.tencent.mobileqq.tvideo.account.qqconnect;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0005R\u001c\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/qqconnect/TVideoQQConnectCacheInKV;", "", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "b", "account", "", "d", "a", "Luq3/k;", "kotlin.jvm.PlatformType", "Luq3/k;", "kv", "Lcom/google/gson/Gson;", "Lkotlin/Lazy;", "c", "()Lcom/google/gson/Gson;", "gson", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TVideoQQConnectCacheInKV {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final k kv = k.b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy gson;

    public TVideoQQConnectCacheInKV() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.tvideo.account.qqconnect.TVideoQQConnectCacheInKV$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Gson invoke() {
                return new Gson();
            }
        });
        this.gson = lazy;
    }

    private final Gson c() {
        return (Gson) this.gson.getValue();
    }

    public final void a() {
        this.kv.r("key_tvideo_qq_connect_auth_info");
    }

    @Nullable
    public final TVideoQQConnectToken b() {
        try {
            return (TVideoQQConnectToken) c().fromJson(this.kv.h("key_tvideo_qq_connect_auth_info", ""), TVideoQQConnectToken.class);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    public final void d(@Nullable TVideoQQConnectToken account) {
        if (account == null) {
            return;
        }
        this.kv.p("key_tvideo_qq_connect_auth_info", c().toJson(account));
    }
}

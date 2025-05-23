package com.tencent.mobileqq.tvideo.account.tenvideo.cache;

import bu2.TVideoAccountInfo;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import jy2.g;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u001c\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/cache/VideoAccountCacheInKV;", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/cache/a;", "Lbu2/b;", "getAccount", "account", "", "a", "clearAccount", "Luq3/k;", "kotlin.jvm.PlatformType", "Luq3/k;", "kv", "Lcom/google/gson/Gson;", "b", "Lkotlin/Lazy;", "()Lcom/google/gson/Gson;", "gson", "<init>", "()V", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class VideoAccountCacheInKV implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final k kv = k.b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy gson;

    public VideoAccountCacheInKV() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.tvideo.account.tenvideo.cache.VideoAccountCacheInKV$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Gson invoke() {
                return new Gson();
            }
        });
        this.gson = lazy;
    }

    private final Gson b() {
        return (Gson) this.gson.getValue();
    }

    @Override // com.tencent.mobileqq.tvideo.account.tenvideo.cache.a
    public void a(@NotNull TVideoAccountInfo account) {
        boolean z16;
        Intrinsics.checkNotNullParameter(account, "account");
        String currentUin = g.e().getCurrentUin();
        if (currentUin != null && currentUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.kv.p("key_tvideo_login_account_v1", b().toJson(account));
        this.kv.p("key_tvideo_login_account_qq_uin_v1", currentUin);
    }

    @Override // com.tencent.mobileqq.tvideo.account.tenvideo.cache.a
    public void clearAccount() {
        this.kv.r("key_tvideo_login_account_v1");
        this.kv.r("key_tvideo_login_account_qq_uin_v1");
    }

    @Override // com.tencent.mobileqq.tvideo.account.tenvideo.cache.a
    @Nullable
    public TVideoAccountInfo getAccount() {
        boolean z16;
        boolean z17;
        String h16 = this.kv.h("key_tvideo_login_account_v1", "");
        String h17 = this.kv.h("key_tvideo_login_account_qq_uin_v1", "");
        String currentUin = g.e().getCurrentUin();
        boolean z18 = false;
        if (currentUin != null && currentUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        if (h17 != null && h17.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return null;
        }
        if (h16 == null || h16.length() == 0) {
            z18 = true;
        }
        if (z18 || !Intrinsics.areEqual(currentUin, h17)) {
            return null;
        }
        try {
            return (TVideoAccountInfo) b().fromJson(h16, TVideoAccountInfo.class);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }
}

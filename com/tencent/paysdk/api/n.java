package com.tencent.paysdk.api;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H&J\b\u0010\u0012\u001a\u00020\u0011H'J\b\u0010\u0013\u001a\u00020\rH'J\b\u0010\u0015\u001a\u00020\u0014H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H'J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/paysdk/api/n;", "", "", "type", "", "e", "a", "Lcom/tencent/paysdk/api/IUserInfoProvider;", "d", "Lcom/tencent/paysdk/api/a;", "getAppInfo", "Lcom/tencent/paysdk/api/d;", "getDeviceInfo", "Landroid/content/Context;", "context", "url", "b", "Lcom/tencent/paysdk/api/p;", "c", "getContext", "", "isRelease", "Lcom/tencent/paysdk/log/b;", "f", "Lcom/tencent/paysdk/api/k;", "g", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public interface n {
    void a();

    void b(@NotNull Context context, @NotNull String url);

    @Nullable
    @NotNull
    p c();

    @NotNull
    IUserInfoProvider d();

    void e(@NotNull String type);

    @Nullable
    @org.jetbrains.annotations.Nullable
    com.tencent.paysdk.log.b f();

    @org.jetbrains.annotations.Nullable
    k g();

    @NotNull
    a getAppInfo();

    @NonNull
    @NotNull
    Context getContext();

    @NotNull
    d getDeviceInfo();

    boolean isRelease();
}

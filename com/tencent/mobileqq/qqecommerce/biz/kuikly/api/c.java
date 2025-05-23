package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH&J7\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rH&J\b\u0010\u0014\u001a\u00020\u0002H&J\b\u0010\u0015\u001a\u00020\u0002H&J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\bH&J\b\u0010\u0018\u001a\u00020\u000bH&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;", "", "", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/a;", "d", "Ljava/io/File;", "b", "", "pageName", "a", "", "forceUpdate", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/k;", "Lkotlin/ParameterName;", "name", "result", "", "e", "g", tl.h.F, "resId", "deleteBundle", "c", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface c {
    @Nullable
    String a(@NotNull String pageName);

    @Nullable
    File b();

    boolean c();

    @Nullable
    DexConfig d();

    void deleteBundle(@NotNull String resId);

    void e(boolean forceUpdate, @Nullable Function1<? super ResError, Unit> result);

    long f();

    long g();

    long h();
}

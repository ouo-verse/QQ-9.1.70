package com.tencent.cache.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\t\u001a\u00020\bH\u0017J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\b\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/cache/api/b;", "", "Lcom/tencent/cache/api/Business;", "business", "", "subBusiness", "", "register", "", "getMemorySize", "Lcom/tencent/cache/api/c;", "getCacheListener", QCircleLpReportDc05507.KEY_CLEAR, "needRemoveSize", "trimMemory", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface b {
    public static final IPatchRedirector $redirector_ = null;

    void clear();

    @Nullable
    c getCacheListener();

    @JvmDefault
    long getMemorySize();

    @JvmDefault
    void register(@NotNull Business business, @NotNull String subBusiness);

    long trimMemory(long needRemoveSize);
}

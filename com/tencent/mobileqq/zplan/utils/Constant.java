package com.tencent.mobileqq.zplan.utils;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/Constant;", "", "", "b", "Lkotlin/Lazy;", "getMemeCachePath", "()Ljava/lang/String;", "memeCachePath", "c", "a", "memeZPlanPath", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class Constant {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Constant f335714a = new Constant();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy memeCachePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy memeZPlanPath;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.zplan.utils.Constant$memeCachePath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                StringBuilder sb5 = new StringBuilder();
                File externalCacheDir = BaseApplication.getContext().getExternalCacheDir();
                sb5.append(externalCacheDir != null ? externalCacheDir.getPath() : null);
                sb5.append("/cmshow");
                return sb5.toString();
            }
        });
        memeCachePath = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.zplan.utils.Constant$memeZPlanPath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                StringBuilder sb5 = new StringBuilder();
                File externalCacheDir = BaseApplication.getContext().getExternalCacheDir();
                sb5.append(externalCacheDir != null ? externalCacheDir.getPath() : null);
                sb5.append("/zplan");
                return sb5.toString();
            }
        });
        memeZPlanPath = lazy2;
    }

    Constant() {
    }

    @NotNull
    public final String a() {
        return (String) memeZPlanPath.getValue();
    }
}

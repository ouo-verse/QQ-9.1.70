package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.VasTabFactory;
import com.tencent.mobileqq.vas.api.INtVasTabFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ8\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/NtVasTabFactoryImpl;", "Lcom/tencent/mobileqq/vas/api/INtVasTabFactory;", "", "owner", "time", "testName", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/vas/api/INtVasTabFactory$NtABTest;", "", "getResultAndExposure", "Lcom/tencent/mobileqq/vas/api/INtVasTabFactory$a;", "buildABTest", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NtVasTabFactoryImpl implements INtVasTabFactory {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/vas/api/impl/NtVasTabFactoryImpl$a", "Lcom/tencent/mobileqq/vas/api/INtVasTabFactory$a;", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements INtVasTabFactory.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f308472a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f308473b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f308474c;

        a(String str, String str2, String str3) {
            this.f308472a = str;
            this.f308473b = str2;
            this.f308474c = str3;
        }
    }

    @Override // com.tencent.mobileqq.vas.api.INtVasTabFactory
    @NotNull
    public INtVasTabFactory.a buildABTest(@NotNull String owner, @NotNull String time, @NotNull String testName) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(testName, "testName");
        return new a(owner, time, testName);
    }

    @Override // com.tencent.mobileqq.vas.api.INtVasTabFactory
    @NotNull
    public Pair<INtVasTabFactory.NtABTest, Map<String, String>> getResultAndExposure(@NotNull String owner, @NotNull String time, @NotNull String testName) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(testName, "testName");
        Pair e16 = VasTabFactory.e(owner, time, testName, null, 8, null);
        return new Pair<>(INtVasTabFactory.NtABTest.valueOf(((VasTabFactory.ABTest) e16.getFirst()).name()), e16.getSecond());
    }
}

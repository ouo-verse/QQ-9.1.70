package com.tencent.mobileqq.qwallet.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/a;", "", "", "totalBalance", "Lkotlin/Pair;", "", "a", "b", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f279249a = new a();

    a() {
    }

    @NotNull
    public final Pair<String, String> a(long totalBalance) {
        String format;
        String str;
        if (totalBalance > RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            str = String.valueOf(totalBalance / RealConnection.IDLE_CONNECTION_HEALTHY_NS);
            format = "\u4ebf";
        } else if (totalBalance > 1000000) {
            str = String.valueOf(totalBalance / 1000000);
            format = "\u4e07";
        } else {
            long j3 = 100;
            String valueOf = String.valueOf(totalBalance / j3);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format(".%02d", Arrays.copyOf(new Object[]{Long.valueOf(totalBalance % j3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            str = valueOf;
        }
        return new Pair<>(str, format);
    }

    @NotNull
    public final Pair<String, String> b(long totalBalance) {
        String format;
        String str;
        String str2;
        if (totalBalance > RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            str2 = String.valueOf(totalBalance / RealConnection.IDLE_CONNECTION_HEALTHY_NS);
            str = "\u4ebf";
        } else if (totalBalance > 1000000) {
            str2 = String.valueOf(totalBalance / 1000000);
            str = "\u4e07";
        } else {
            long j3 = 100;
            String valueOf = String.valueOf(totalBalance / j3);
            long j16 = totalBalance % j3;
            if (j16 == 0) {
                format = "";
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                format = String.format(".%02d", Arrays.copyOf(new Object[]{Long.valueOf(j16)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            str = format;
            str2 = valueOf;
        }
        return new Pair<>(str2, str);
    }
}

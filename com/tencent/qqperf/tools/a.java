package com.tencent.qqperf.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqperf/tools/a;", "", "Landroid/os/Bundle;", "bundle", "", "c", "Lcom/tencent/qqperf/tools/g;", "f", "b", "", "bytes", "", "a", "Landroid/os/Parcelable;", "parcelable", "e", "d", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f363411a = new a();

    a() {
    }

    @JvmStatic
    public static final double a(int bytes) {
        return bytes / 1000.0f;
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        SizeTree f16 = f(bundle);
        String key = f16.getKey();
        int totalSize = f16.getTotalSize();
        List<SizeTree> c16 = f16.c();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.UK, "%s contains %d keys and measures %,.1f KB when serialized as a Parcel", Arrays.copyOf(new Object[]{key, Integer.valueOf(c16.size()), Double.valueOf(a(totalSize))}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        for (SizeTree sizeTree : c16) {
            String key2 = sizeTree.getKey();
            int totalSize2 = sizeTree.getTotalSize();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(format);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.UK, "\n* %s = %,.1f KB", Arrays.copyOf(new Object[]{key2, Double.valueOf(a(totalSize2))}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
            sb5.append(format2);
            format = sb5.toString();
        }
        return format;
    }

    @JvmStatic
    @NotNull
    public static final String c(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Bundle bundle2 = new Bundle(bundle);
        try {
            int d16 = d(bundle);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Bundle info:");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.UK, "contains %d keys and measures %,.1f KB when serialized as a Parcel", Arrays.copyOf(new Object[]{Integer.valueOf(bundle2.keySet().size()), Double.valueOf(a(d16))}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            sb5.append(format);
            String sb6 = sb5.toString();
            for (String str : bundle2.keySet()) {
                bundle.remove(str);
                int d17 = d(bundle);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format(Locale.UK, "\n* %s = %,.1f KB", Arrays.copyOf(new Object[]{str, Double.valueOf(a(d16 - d17))}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
                sb7.append(format2);
                sb6 = sb7.toString();
                d16 = d17;
            }
            return sb6;
        } finally {
            bundle.putAll(bundle2);
        }
    }

    @JvmStatic
    public static final int d(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.writeBundle(bundle);
            return obtain.dataSize();
        } finally {
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    @JvmStatic
    public static final int e(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "parcelable");
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        try {
            obtain.writeParcelable(parcelable, 0);
            return obtain.dataSize();
        } finally {
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    @JvmStatic
    @NotNull
    public static final SizeTree f(@NotNull Bundle bundle) {
        List emptyList;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ArrayList arrayList = new ArrayList(bundle.size());
        Bundle bundle2 = new Bundle(bundle);
        try {
            int d16 = d(bundle);
            for (String key : bundle2.keySet()) {
                bundle.remove(key);
                int d17 = d(bundle);
                Intrinsics.checkNotNullExpressionValue(key, "key");
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                arrayList.add(new SizeTree(key, d16 - d17, emptyList));
                d16 = d17;
            }
            bundle.putAll(bundle2);
            return new SizeTree("Bundle" + System.identityHashCode(bundle), d(bundle), arrayList);
        } catch (Throwable th5) {
            bundle.putAll(bundle2);
            throw th5;
        }
    }
}

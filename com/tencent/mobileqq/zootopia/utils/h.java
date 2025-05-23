package com.tencent.mobileqq.zootopia.utils;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.util.cu;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/h;", "", "", "f", "c", "", "g", "e", "b", "d", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f329557a = new h();

    h() {
    }

    public final long a() {
        return cu.c();
    }

    public final long b() {
        return cu.b();
    }

    public final long c() {
        long a16;
        if (g()) {
            a16 = b();
        } else {
            a16 = a();
        }
        return a16 / 1024;
    }

    public final long d() {
        try {
            StatFs statFs = new StatFs(IQzoneHardwareRestriction.APP_ROOT);
            return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long e() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long f() {
        long d16;
        if (g()) {
            d16 = e();
        } else {
            d16 = d();
        }
        return d16 / 1024;
    }

    public final boolean g() {
        return cu.e();
    }
}

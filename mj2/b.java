package mj2;

import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final ee4.a f416865a = new a();

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements ee4.a {
        a() {
        }

        @Override // ee4.a
        public void d(@Nullable String str, @Nullable String str2) {
            b.a(str, str2);
        }

        @Override // ee4.a
        public void e(@Nullable String str, @Nullable String str2) {
            b.b(str, str2);
        }

        @Override // ee4.a
        public void i(@Nullable String str, @Nullable String str2) {
            b.b(str, str2);
        }

        @Override // ee4.a
        public void v(@Nullable String str, @Nullable String str2) {
            b.a(str, str2);
        }

        @Override // ee4.a
        public void w(@Nullable String str, @Nullable String str2) {
            b.b(str, str2);
        }

        @Override // ee4.a
        public void e(@Nullable String str, @Nullable String str2, @Nullable Throwable th5) {
            b.c(str, str2, th5);
        }
    }

    public static void b(@NonNull String str, @NonNull String str2) {
        QLog.e("MODULE_GY_TAVCUT :" + str, 1, str2);
    }

    public static void c(@NonNull String str, @NonNull String str2, @android.support.annotation.Nullable Throwable th5) {
        QLog.e("MODULE_GY_TAVCUT :" + str, 1, str2, th5);
    }

    public static void d(int i3, int i16) {
        e(i16);
        ee4.b.h(f416865a);
    }

    public static void e(int i3) {
        ee4.b.g(i3);
    }

    public static void a(@NonNull String str, @NonNull String str2) {
    }
}

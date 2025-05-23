package com.tencent.mobileqq.app;

import android.os.Message;
import com.tencent.ams.dynamicwidget.http.Method;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H&J$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0019\u001a\u00020\u0004H&J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u001b\u001a\u00020\u0014H&J\u001a\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u001d\u001a\u00020\tH&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH&J*\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/app/bc;", "", "Ljava/lang/Runnable;", "runnable", "", Method.POST, "", "delayMs", "postDelayed", "Landroid/os/Message;", "message", tl.h.F, "e", "", "what", "sendEmptyMessage", "b", "obj", "a", "g", "", "c", "f", "d", "removeMessages", "removeAll", "removeCallbacksAndMessages", "j", "obtainMessage", "i", "arg1", "arg2", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface bc {
    void a(int what, @Nullable Object obj);

    void b(int what, long delayMs);

    boolean c(int what);

    void d(@NotNull Runnable runnable);

    void e(@NotNull Message message, long delayMs);

    void f(@NotNull Runnable runnable);

    void g(int what, @Nullable Object obj, long delayMs);

    void h(@NotNull Message message);

    @NotNull
    Message i();

    boolean j();

    @NotNull
    Message obtainMessage(int what);

    @NotNull
    Message obtainMessage(int what, int arg1, int arg2, @Nullable Object obj);

    @NotNull
    Message obtainMessage(int what, @Nullable Object obj);

    void post(@NotNull Runnable runnable);

    void postDelayed(@NotNull Runnable runnable, long delayMs);

    void removeAll();

    void removeCallbacksAndMessages(@Nullable Object obj);

    void removeMessages(int what);

    void sendEmptyMessage(int what);
}

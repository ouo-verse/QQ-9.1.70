package com.tencent.guild.aio.util;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/util/ae;", "", "Landroid/content/Context;", "context", "", "milliSeconds", "", "b", "", "timings", "", "repeat", "c", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ae f112367a = new ae();

    ae() {
    }

    public static /* synthetic */ void d(ae aeVar, Context context, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 20;
        }
        aeVar.b(context, j3);
    }

    public static /* synthetic */ void e(ae aeVar, Context context, long[] jArr, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = -1;
        }
        aeVar.c(context, jArr, i3);
    }

    public final void a(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).cancel();
    }

    public final void b(@NotNull Context context, long milliSeconds) {
        Vibrator vibrator;
        VibrationEffect createOneShot;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("vibrator");
        if (systemService instanceof Vibrator) {
            vibrator = (Vibrator) systemService;
        } else {
            vibrator = null;
        }
        if (vibrator != null) {
            if (Build.VERSION.SDK_INT > 25) {
                createOneShot = VibrationEffect.createOneShot(milliSeconds, -1);
                vibrator.vibrate(createOneShot);
            } else {
                vibrator.vibrate(milliSeconds);
            }
        }
    }

    public final void c(@NotNull Context context, @NotNull long[] timings, int repeat) {
        Vibrator vibrator;
        VibrationEffect createWaveform;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(timings, "timings");
        Object systemService = context.getSystemService("vibrator");
        if (systemService instanceof Vibrator) {
            vibrator = (Vibrator) systemService;
        } else {
            vibrator = null;
        }
        if (vibrator != null) {
            if (Build.VERSION.SDK_INT > 25) {
                createWaveform = VibrationEffect.createWaveform(timings, repeat);
                vibrator.vibrate(createWaveform);
            } else {
                vibrator.vibrate(timings, repeat);
            }
        }
    }
}

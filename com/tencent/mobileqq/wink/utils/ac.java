package com.tencent.mobileqq.wink.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.RequiresApi;
import com.tencent.av.utils.AVUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RequiresApi(21)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/ac;", "", "Landroid/content/Context;", "context", "", "milliseconds", "", "b", "Landroid/media/AudioAttributes;", "a", "()Landroid/media/AudioAttributes;", "audioAttributes", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ac f326659a = new ac();

    ac() {
    }

    private final AudioAttributes a() {
        if (AVUtil.p()) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setUsage(6);
            builder.setContentType(0);
            return builder.build();
        }
        return null;
    }

    public final void b(@Nullable Context context, long milliseconds) {
        Vibrator vibrator;
        VibrationEffect createOneShot;
        if (context == null) {
            vibrator = null;
        } else {
            Object systemService = context.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            vibrator = (Vibrator) systemService;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            createOneShot = VibrationEffect.createOneShot(milliseconds, -1);
            if (vibrator != null) {
                vibrator.vibrate(createOneShot);
                return;
            }
            return;
        }
        if (vibrator != null) {
            AudioAttributes a16 = f326659a.a();
            if (a16 == null) {
                vibrator.vibrate(milliseconds);
            } else {
                vibrator.vibrate(milliseconds, a16);
            }
        }
    }
}

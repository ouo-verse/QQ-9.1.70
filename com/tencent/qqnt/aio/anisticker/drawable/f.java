package com.tencent.qqnt.aio.anisticker.drawable;

import android.graphics.drawable.Drawable;
import com.tencent.aekit.plugin.core.AIInput;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0007H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0005H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/drawable/f;", "", "", "isRunning", "isAllow", "", "c", "", "repeatCount", h.F, AIInput.KEY_FRAME, "a", "Lcom/tencent/qqnt/aio/anisticker/drawable/g;", "callback", "g", "e", "d", "f", "Landroid/graphics/drawable/Drawable;", "getDrawable", "recycle", "start", "stop", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface f {
    void a(int frame);

    void c(boolean isAllow);

    int d();

    void e(@Nullable g callback);

    int f();

    void g(@Nullable g callback);

    @Nullable
    Drawable getDrawable();

    void h(int repeatCount);

    boolean isRunning();

    void recycle();

    void start();

    void stop();
}

package com.tencent.cachedrawable.dynamicdrawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0012\rJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/d;", "", "", "stop", "restart", "", "loopCount", "setLoopCount", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "listener", "d", "Lcom/tencent/cachedrawable/dynamicdrawable/d$b;", "selfDrawHelper", "b", "getHeight", "getFrameCount", "c", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;", "a", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public interface d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "", "", "onEnd", "onStart", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public interface a {
        void onEnd();

        void onStart();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/d$b;", "", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public interface b {
        void a(@NotNull Canvas canvas, @NotNull Bitmap bitmap);
    }

    @Nullable
    CacheDrawable.CacheState a();

    void b(@NotNull b selfDrawHelper);

    int c();

    void d(@NotNull a listener);

    int getFrameCount();

    int getHeight();

    void restart();

    void setLoopCount(int loopCount);

    void stop();
}

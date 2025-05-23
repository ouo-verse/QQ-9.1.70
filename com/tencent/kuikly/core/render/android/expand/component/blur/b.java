package com.tencent.kuikly.core.render.android.expand.component.blur;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/blur/b;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "radius", "blur", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "destroy", "", "b", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a {
        public static boolean a(@NotNull b bVar) {
            return false;
        }
    }

    void a(@NotNull Canvas canvas, @NotNull Bitmap bitmap);

    boolean b();

    @NotNull
    Bitmap blur(@NotNull Bitmap bitmap, float radius);

    void destroy();
}

package com.tencent.mobileqq.zplan.aigc.render;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "", "result", "", "f", "", "Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "model", "e", "c", "", "resourcePath", "d", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onScreenShotResult", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface g {
    void a(String resourcePath);

    void b(int result);

    void c(boolean result);

    void d(String resourcePath);

    void e(boolean result, AIGCWhiteModel model);

    void f(int result);

    void onScreenShotResult(Bitmap bitmap);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a {
        public static void b(g gVar, String resourcePath) {
            Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
        }

        public static void c(g gVar, String resourcePath) {
            Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
        }

        public static void g(g gVar, boolean z16, AIGCWhiteModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
        }

        public static void a(g gVar, int i3) {
        }

        public static void d(g gVar, Bitmap bitmap) {
        }

        public static void e(g gVar, int i3) {
        }

        public static void f(g gVar, boolean z16) {
        }
    }
}

package com.tencent.kuikly.core.render.android.expand.component.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.kuikly.core.render.android.expand.component.blur.b;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import d01.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/blur/l;", "Lcom/tencent/kuikly/core/render/android/expand/component/blur/b;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "c", "", "radius", "blur", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "destroy", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/renderscript/RenderScript;", "b", "Landroid/renderscript/RenderScript;", "renderScript", "Landroid/renderscript/ScriptIntrinsicBlur;", "Landroid/renderscript/ScriptIntrinsicBlur;", "blurScript", "Landroid/renderscript/Allocation;", "d", "Landroid/renderscript/Allocation;", "outAllocation", "", "e", "I", "lastBitmapWidth", "f", "lastBitmapHeight", "g", "Z", "hadDestroy", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", tl.h.F, "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class l implements b {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Paint paint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private RenderScript renderScript;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ScriptIntrinsicBlur blurScript;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Allocation outAllocation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastBitmapWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastBitmapHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hadDestroy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/blur/l$a;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/content/Context;", "context", "", "blurRadius", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.blur.l$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final Drawable a(@NotNull Drawable drawable, @NotNull Context context, float blurRadius) {
            RenderScript renderScript;
            int i3;
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            Intrinsics.checkNotNullParameter(context, "context");
            ScriptIntrinsicBlur scriptIntrinsicBlur = null;
            if (!(drawable instanceof BitmapDrawable)) {
                return null;
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
                return null;
            }
            int i16 = (int) 150.0f;
            int height = (int) (bitmap.getHeight() * (150.0f / bitmap.getWidth()));
            Bitmap createBitmap = Bitmap.createBitmap(i16, height, Bitmap.Config.ARGB_8888);
            int i17 = 0;
            new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, i16, height), (Paint) null);
            try {
                renderScript = RenderScript.create(context);
            } catch (Throwable th5) {
                w.f392617a.b("KRRenderScriptBlur", "blurImage renderScript failed: " + th5);
                renderScript = null;
            }
            if (renderScript == null) {
                return new BitmapDrawable(context.getResources(), createBitmap);
            }
            try {
                scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            } catch (Throwable th6) {
                w.f392617a.b("KRRenderScriptBlur", "blurImage ScriptIntrinsicBlur failed: " + th6);
            }
            if (scriptIntrinsicBlur == null) {
                return new BitmapDrawable(context.getResources(), createBitmap);
            }
            Allocation input = Allocation.createFromBitmap(renderScript, createBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Intrinsics.checkNotNullExpressionValue(input, "input");
            Allocation createTyped = Allocation.createTyped(renderScript, input.getType());
            if (blurRadius == 12.5f) {
                i3 = 5;
            } else {
                i3 = 3;
            }
            float min = Math.min(25.0f, Math.max(0.0f, (blurRadius / 12.5f) * 25.0f));
            if (i3 >= 0) {
                while (true) {
                    input.copyFrom(createBitmap);
                    scriptIntrinsicBlur.setInput(input);
                    scriptIntrinsicBlur.setRadius(min);
                    scriptIntrinsicBlur.forEach(createTyped);
                    createTyped.copyTo(createBitmap);
                    if (i17 == i3) {
                        break;
                    }
                    i17++;
                }
            }
            input.destroy();
            createTyped.destroy();
            scriptIntrinsicBlur.destroy();
            renderScript.finish();
            return new BitmapDrawable(context.getResources(), createBitmap);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint(2);
        this.lastBitmapWidth = -1;
        this.lastBitmapHeight = -1;
        try {
            this.renderScript = RenderScript.create(context);
        } catch (Throwable th5) {
            w.f392617a.b("KRRenderScriptBlur", "init renderScript failed: " + th5);
        }
        try {
            RenderScript renderScript = this.renderScript;
            this.blurScript = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        } catch (Throwable th6) {
            w.f392617a.b("KRRenderScriptBlur", "init ScriptIntrinsicBlur failed: " + th6);
        }
    }

    private final boolean c(Bitmap bitmap) {
        if (bitmap.getHeight() == this.lastBitmapHeight && bitmap.getWidth() == this.lastBitmapWidth) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.blur.b
    public void a(@NotNull Canvas canvas, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.blur.b
    public boolean b() {
        return b.a.a(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.blur.b
    @NotNull
    public Bitmap blur(@NotNull Bitmap bitmap, float radius) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        RenderScript renderScript = this.renderScript;
        if (renderScript != null && this.blurScript != null) {
            Allocation allocation = Allocation.createFromBitmap(renderScript, bitmap);
            if (!c(bitmap)) {
                Allocation allocation2 = this.outAllocation;
                if (allocation2 != null) {
                    allocation2.destroy();
                }
                RenderScript renderScript2 = this.renderScript;
                Intrinsics.checkNotNullExpressionValue(allocation, "allocation");
                this.outAllocation = Allocation.createTyped(renderScript2, allocation.getType());
                this.lastBitmapWidth = bitmap.getWidth();
                this.lastBitmapHeight = bitmap.getHeight();
            }
            if (radius <= 0) {
                radius = 1.0f;
            } else if (radius > 25.0f) {
                radius = 25.0f;
            }
            try {
                ScriptIntrinsicBlur scriptIntrinsicBlur = this.blurScript;
                if (scriptIntrinsicBlur != null) {
                    scriptIntrinsicBlur.setRadius(radius);
                }
                ScriptIntrinsicBlur scriptIntrinsicBlur2 = this.blurScript;
                if (scriptIntrinsicBlur2 != null) {
                    scriptIntrinsicBlur2.setInput(allocation);
                }
                ScriptIntrinsicBlur scriptIntrinsicBlur3 = this.blurScript;
                if (scriptIntrinsicBlur3 != null) {
                    scriptIntrinsicBlur3.forEach(this.outAllocation);
                }
                Allocation allocation3 = this.outAllocation;
                if (allocation3 != null) {
                    allocation3.copyTo(bitmap);
                }
            } catch (Throwable th5) {
                w.f392617a.b("RenderScriptBlur", "blur error: " + th5);
            }
            allocation.destroy();
        }
        return bitmap;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.blur.b
    public void destroy() {
        if (this.hadDestroy) {
            return;
        }
        this.hadDestroy = true;
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.blurScript;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript renderScript = this.renderScript;
        if (renderScript != null) {
            renderScript.destroy();
        }
        Allocation allocation = this.outAllocation;
        if (allocation != null) {
            allocation.destroy();
        }
    }
}

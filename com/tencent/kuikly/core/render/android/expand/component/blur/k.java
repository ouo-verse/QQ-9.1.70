package com.tencent.kuikly.core.render.android.expand.component.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import androidx.annotation.RequiresApi;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@RequiresApi(31)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/blur/k;", "Lcom/tencent/kuikly/core/render/android/expand/component/blur/b;", "", "b", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "radius", "blur", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "destroy", "Landroid/graphics/RenderNode;", "Landroid/graphics/RenderNode;", "node", "", "I", "width", "c", "height", "d", UserInfo.SEX_FEMALE, "lastBlurRadius", "e", "Lcom/tencent/kuikly/core/render/android/expand/component/blur/b;", "fallbackBlur", "f", "Z", "hadDestroy", "Landroid/content/Context;", "g", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class k implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RenderNode node;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float lastBlurRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b fallbackBlur;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hadDestroy;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    public k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.node = new RenderNode("BlurViewNode");
        this.lastBlurRadius = 1.0f;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.blur.b
    public void a(@NotNull Canvas canvas, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (canvas.isHardwareAccelerated()) {
            canvas.drawRenderNode(this.node);
            return;
        }
        if (this.fallbackBlur == null) {
            this.fallbackBlur = new l(this.context);
        }
        b bVar = this.fallbackBlur;
        Intrinsics.checkNotNull(bVar);
        bVar.blur(bitmap, this.lastBlurRadius);
        b bVar2 = this.fallbackBlur;
        Intrinsics.checkNotNull(bVar2);
        bVar2.a(canvas, bitmap);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.blur.b
    public boolean b() {
        return true;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.blur.b
    @NotNull
    public Bitmap blur(@NotNull Bitmap bitmap, float radius) {
        RecordingCanvas beginRecording;
        RenderEffect createBlurEffect;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.lastBlurRadius = radius;
        if (bitmap.getWidth() != this.width || bitmap.getHeight() != this.height) {
            this.height = bitmap.getHeight();
            int width = bitmap.getWidth();
            this.width = width;
            this.node.setPosition(0, 0, width, this.height);
        }
        beginRecording = this.node.beginRecording();
        Intrinsics.checkNotNullExpressionValue(beginRecording, "node.beginRecording()");
        beginRecording.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.node.endRecording();
        RenderNode renderNode = this.node;
        createBlurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.MIRROR);
        renderNode.setRenderEffect(createBlurEffect);
        return bitmap;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.blur.b
    public void destroy() {
        if (this.hadDestroy) {
            return;
        }
        this.hadDestroy = true;
        this.node.discardDisplayList();
        b bVar = this.fallbackBlur;
        if (bVar != null) {
            bVar.destroy();
        }
    }
}

package com.tencent.mobileqq.guild.media.core.logic.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004J(\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0002R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/video/MediaVideoTextureView;", "Landroid/view/TextureView;", "", h.F, "", "w", "setVideoSize", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Lus1/a;", "listener", "setSurfaceListener", "g", "d", "I", "videoW", "e", "videoH", "Landroid/view/Surface;", "f", "Landroid/view/Surface;", "surface", "Landroid/graphics/SurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "curSurfaceTexture", "i", "Lus1/a;", "surfaceListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaVideoTextureView extends TextureView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int videoW;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int videoH;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface surface;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SurfaceTexture curSurfaceTexture;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private us1.a surfaceListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/video/MediaVideoTextureView$a", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            if (MediaVideoTextureView.this.curSurfaceTexture == null) {
                MediaVideoTextureView.this.curSurfaceTexture = surface;
                MediaVideoTextureView.this.surface = new Surface(surface);
                us1.a aVar = MediaVideoTextureView.this.surfaceListener;
                if (aVar != null) {
                    Surface surface2 = MediaVideoTextureView.this.surface;
                    Intrinsics.checkNotNull(surface2);
                    aVar.onSurfaceCreated(surface2);
                    return;
                }
                return;
            }
            MediaVideoTextureView mediaVideoTextureView = MediaVideoTextureView.this;
            SurfaceTexture surfaceTexture = mediaVideoTextureView.curSurfaceTexture;
            Intrinsics.checkNotNull(surfaceTexture);
            mediaVideoTextureView.setSurfaceTexture(surfaceTexture);
            MediaVideoTextureView.this.h();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            MediaVideoTextureView.this.curSurfaceTexture = surface;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            us1.a aVar = MediaVideoTextureView.this.surfaceListener;
            if (aVar != null) {
                aVar.onSurfaceSizeChanged(width, height);
            }
            MediaVideoTextureView.this.h();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaVideoTextureView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (this.videoW != 0 && this.videoH != 0) {
            if (getWidth() != 0 || getHeight() != 0) {
                float width = (getWidth() * 1.0f) / this.videoW;
                float height = (getHeight() * 1.0f) / this.videoH;
                Matrix matrix = new Matrix();
                matrix.preTranslate((getWidth() - this.videoW) >> 1, (getHeight() - this.videoH) >> 1);
                matrix.preScale((this.videoW * 1.0f) / getWidth(), (this.videoH * 1.0f) / getHeight());
                if (width >= height) {
                    matrix.postScale(height, height, getWidth() >> 1, getHeight() >> 1);
                } else {
                    matrix.postScale(width, width, getWidth() >> 1, getHeight() >> 1);
                }
                setTransform(matrix);
                postInvalidate();
            }
        }
    }

    public final void g() {
        us1.a aVar = this.surfaceListener;
        if (aVar != null) {
            aVar.onSurfaceDestroyed(this.surface);
        }
        SurfaceTexture surfaceTexture = this.curSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.curSurfaceTexture = null;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        h();
    }

    public final void setSurfaceListener(@NotNull us1.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.surfaceListener = listener;
    }

    public final void setVideoSize(int w3, int h16) {
        this.videoW = w3;
        this.videoH = h16;
        h();
    }

    public /* synthetic */ MediaVideoTextureView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaVideoTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setSurfaceTextureListener(new a());
    }
}

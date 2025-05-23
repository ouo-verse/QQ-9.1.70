package com.tencent.state.square.media.render;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.media.ISquareRender;
import com.tencent.state.square.media.VideoInfo;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 72\u00020\u0001:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020\nH\u0016J,\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020+0/H\u0017J \u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0015H\u0016J\u0012\u00104\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u00105\u001a\u00020+2\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020+2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0015X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u00068"}, d2 = {"Lcom/tencent/state/square/media/render/SquareAbsRender;", "Lcom/tencent/state/square/media/ISquareRender;", "()V", "displaySurface", "Landroid/graphics/SurfaceTexture;", "getDisplaySurface", "()Landroid/graphics/SurfaceTexture;", "setDisplaySurface", "(Landroid/graphics/SurfaceTexture;)V", "isFirstFrame", "", "()Z", "setFirstFrame", "(Z)V", "listener", "Lcom/tencent/state/square/media/ISquareRender$Listener;", "getListener", "()Lcom/tencent/state/square/media/ISquareRender$Listener;", "setListener", "(Lcom/tencent/state/square/media/ISquareRender$Listener;)V", "mp4Height", "", "getMp4Height", "()I", "setMp4Height", "(I)V", "mp4Width", "getMp4Width", "setMp4Width", "surfaceHeight", "getSurfaceHeight", "setSurfaceHeight", "surfaceWidth", "getSurfaceWidth", "setSurfaceWidth", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "", "getUniqueId", "()Ljava/lang/String;", "setUniqueId", "(Ljava/lang/String;)V", "isSurfaceReady", "onBeforeDecode", "", "videoWidth", "videoHeight", "callback", "Lkotlin/Function1;", "onSurfaceAvailable", "surface", "width", "height", "onSurfaceDestroyed", "onSurfaceSizeChanged", "setRenderListener", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class SquareAbsRender implements ISquareRender {
    private static final String TAG = "Square_SquareAbsRender";
    private SurfaceTexture displaySurface;
    private ISquareRender.Listener listener;
    private int surfaceHeight;
    private int surfaceWidth;
    private String uniqueId = "";
    private int mp4Width = -1;
    private int mp4Height = -1;
    private boolean isFirstFrame = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public final SurfaceTexture getDisplaySurface() {
        return this.displaySurface;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ISquareRender.Listener getListener() {
        return this.listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMp4Height() {
        return this.mp4Height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMp4Width() {
        return this.mp4Width;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getSurfaceHeight() {
        return this.surfaceHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getSurfaceWidth() {
        return this.surfaceWidth;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: isFirstFrame, reason: from getter */
    public final boolean getIsFirstFrame() {
        return this.isFirstFrame;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public boolean isSurfaceReady() {
        return this.displaySurface != null;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onBeforeDecode(int videoWidth, int videoHeight, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mp4Width = videoWidth;
        this.mp4Height = videoHeight;
        this.isFirstFrame = true;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onFrameRender(MediaCodec.BufferInfo info, ByteBuffer yBuffer, ByteBuffer uvBuffer, ByteBuffer alphaBuffer) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(yBuffer, "yBuffer");
        Intrinsics.checkNotNullParameter(uvBuffer, "uvBuffer");
        Intrinsics.checkNotNullParameter(alphaBuffer, "alphaBuffer");
        ISquareRender.DefaultImpls.onFrameRender(this, info, yBuffer, uvBuffer, alphaBuffer);
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onOutFormatChanged(VideoInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ISquareRender.DefaultImpls.onOutFormatChanged(this, info);
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onSurfaceAvailable(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.displaySurface = surface;
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, '(' + this.uniqueId + ")(" + hashCode() + ") onSurfaceAvailable: " + surface, null, 4, null);
        this.surfaceWidth = width;
        this.surfaceHeight = height;
        this.isFirstFrame = true;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onSurfaceSizeChanged(int width, int height) {
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, '(' + this.uniqueId + ")(" + hashCode() + ") onSurfaceSizeChanged: " + width + ", " + height, null, 4, null);
        this.surfaceWidth = width;
        this.surfaceHeight = height;
    }

    protected final void setDisplaySurface(SurfaceTexture surfaceTexture) {
        this.displaySurface = surfaceTexture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setFirstFrame(boolean z16) {
        this.isFirstFrame = z16;
    }

    protected final void setListener(ISquareRender.Listener listener) {
        this.listener = listener;
    }

    protected final void setMp4Height(int i3) {
        this.mp4Height = i3;
    }

    protected final void setMp4Width(int i3) {
        this.mp4Width = i3;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void setRenderListener(ISquareRender.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    protected final void setSurfaceHeight(int i3) {
        this.surfaceHeight = i3;
    }

    protected final void setSurfaceWidth(int i3) {
        this.surfaceWidth = i3;
    }

    public final void setUniqueId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uniqueId = str;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onFrameRender(MediaCodec.BufferInfo info, boolean z16) {
        Intrinsics.checkNotNullParameter(info, "info");
        ISquareRender.DefaultImpls.onFrameRender(this, info, z16);
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onSurfaceDestroyed(SurfaceTexture surface) {
        this.displaySurface = null;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onFrameRender(ByteBuffer rgba) {
        Intrinsics.checkNotNullParameter(rgba, "rgba");
        ISquareRender.DefaultImpls.onFrameRender(this, rgba);
    }
}

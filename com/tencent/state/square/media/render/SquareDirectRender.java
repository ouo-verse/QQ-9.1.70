package com.tencent.state.square.media.render;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.view.Surface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\rH\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/media/render/SquareDirectRender;", "Lcom/tencent/state/square/media/render/SquareAbsRender;", "()V", "getOutputSurface", "Landroid/view/Surface;", "isDestroying", "", "onBeforeDecode", "", "videoWidth", "", "videoHeight", "callback", "Lkotlin/Function1;", "onFrameRender", "info", "Landroid/media/MediaCodec$BufferInfo;", "image", "Landroid/media/Image;", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareDirectRender extends SquareAbsRender {
    @Override // com.tencent.state.square.media.ISquareRender
    public Surface getOutputSurface() {
        SurfaceTexture displaySurface = getDisplaySurface();
        if (displaySurface != null) {
            return new Surface(displaySurface);
        }
        return null;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public boolean isDestroying() {
        return false;
    }

    @Override // com.tencent.state.square.media.render.SquareAbsRender, com.tencent.state.square.media.ISquareRender
    public void onBeforeDecode(int videoWidth, int videoHeight, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(Boolean.valueOf(isSurfaceReady()));
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onFrameRender(MediaCodec.BufferInfo info, Image image) {
        Intrinsics.checkNotNullParameter(info, "info");
    }
}

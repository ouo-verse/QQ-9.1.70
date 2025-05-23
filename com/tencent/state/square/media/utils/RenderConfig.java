package com.tencent.state.square.media.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/media/utils/RenderConfig;", "", "()V", "alphaRect", "Lcom/tencent/state/square/media/utils/PointRect;", "getAlphaRect", "()Lcom/tencent/state/square/media/utils/PointRect;", "setAlphaRect", "(Lcom/tencent/state/square/media/utils/PointRect;)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "rgbRect", "getRgbRect", "setRgbRect", "videoHeight", "getVideoHeight", "setVideoHeight", "videoWidth", "getVideoWidth", "setVideoWidth", "width", "getWidth", "setWidth", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RenderConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int height;
    private int videoHeight;
    private int videoWidth;
    private int width;
    private PointRect alphaRect = new PointRect(0, 0, 0, 0);
    private PointRect rgbRect = new PointRect(0, 0, 0, 0);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/square/media/utils/RenderConfig$Companion;", "", "()V", "default", "Lcom/tencent/state/square/media/utils/RenderConfig;", "videoWidth", "", "videoHeight", "square_media_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        /* renamed from: default, reason: not valid java name */
        public final RenderConfig m252default(int videoWidth, int videoHeight) {
            RenderConfig renderConfig = new RenderConfig();
            renderConfig.setVideoWidth(videoWidth);
            renderConfig.setVideoHeight(videoHeight);
            renderConfig.setWidth(videoWidth / 2);
            renderConfig.setHeight(videoHeight);
            renderConfig.setAlphaRect(new PointRect(0, 0, renderConfig.getWidth(), renderConfig.getHeight()));
            renderConfig.setRgbRect(new PointRect(renderConfig.getWidth(), 0, renderConfig.getWidth(), renderConfig.getHeight()));
            return renderConfig;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final PointRect getAlphaRect() {
        return this.alphaRect;
    }

    public final int getHeight() {
        return this.height;
    }

    public final PointRect getRgbRect() {
        return this.rgbRect;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setAlphaRect(PointRect pointRect) {
        Intrinsics.checkNotNullParameter(pointRect, "<set-?>");
        this.alphaRect = pointRect;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setRgbRect(PointRect pointRect) {
        Intrinsics.checkNotNullParameter(pointRect, "<set-?>");
        this.rgbRect = pointRect;
    }

    public final void setVideoHeight(int i3) {
        this.videoHeight = i3;
    }

    public final void setVideoWidth(int i3) {
        this.videoWidth = i3;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }
}

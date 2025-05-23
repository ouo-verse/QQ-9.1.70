package com.tencent.state.square.media;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.media.ISquarePlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001:B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020#H\u0014J \u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0016J\u0012\u0010+\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010,\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0016J\u0012\u0010-\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010.\u001a\u00020#H\u0016J\u0006\u0010/\u001a\u00020#J\b\u00100\u001a\u00020#H\u0016J\b\u00101\u001a\u00020#H\u0016J\b\u00102\u001a\u00020#H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020%H\u0016J\u0010\u00106\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u00107\u001a\u00020#H\u0016J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020!H\u0016J\b\u00109\u001a\u00020#H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/tencent/state/square/media/SquareVideoView;", "Landroid/widget/FrameLayout;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/state/square/media/ISquarePlayer;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "playerPool", "Lcom/tencent/state/square/media/SquarePlayerPool;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/state/square/media/SquarePlayerPool;)V", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/media/PlayConfig;", "displaySurface", "Landroid/graphics/SurfaceTexture;", "listener", "Lcom/tencent/state/square/media/ISquarePlayer$Listener;", "player", "Lcom/tencent/state/square/media/SquarePlayer;", "getPlayerPool", "()Lcom/tencent/state/square/media/SquarePlayerPool;", "setPlayerPool", "(Lcom/tencent/state/square/media/SquarePlayerPool;)V", "surfaceHeight", "surfaceWidth", "view", "Landroid/view/TextureView;", "checkPlayer", "getState", "Lcom/tencent/state/square/media/PlayerState;", "getVideoSource", "Lcom/tencent/state/square/media/MediaSource;", "initTextureView", "", "isDestroying", "", NodeProps.ON_ATTACHED_TO_WINDOW, "onSurfaceTextureAvailable", "surface", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "recyclePlayer", "release", "reset", "resume", "setListener", "setLoopPlay", "isLoopPlay", "setPlayConfig", "start", "source", "stop", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareVideoView extends FrameLayout implements TextureView.SurfaceTextureListener, ISquarePlayer {
    private static final String TAG = "Square_SquareVideoView";
    private PlayConfig config;
    private SurfaceTexture displaySurface;
    private ISquarePlayer.Listener listener;
    private SquarePlayer player;
    private SquarePlayerPool playerPool;
    private int surfaceHeight;
    private int surfaceWidth;
    private TextureView view;

    public SquareVideoView(Context context) {
        this(context, null, 0, null, 14, null);
    }

    private final SquarePlayer checkPlayer() {
        SquarePlayer squarePlayer;
        SquarePlayer squarePlayer2;
        if (this.player == null) {
            SquarePlayerPool squarePlayerPool = this.playerPool;
            SquarePlayer acquire = squarePlayerPool != null ? squarePlayerPool.acquire() : null;
            this.player = acquire;
            ISquarePlayer.Listener listener = this.listener;
            if (listener != null && acquire != null) {
                acquire.setListener(listener);
            }
            PlayConfig playConfig = this.config;
            if (playConfig != null && (squarePlayer2 = this.player) != null) {
                squarePlayer2.setPlayConfig(playConfig);
            }
            SurfaceTexture surfaceTexture = this.displaySurface;
            if (surfaceTexture != null && (squarePlayer = this.player) != null) {
                squarePlayer.onSurfaceAvailable(surfaceTexture, this.surfaceWidth, this.surfaceHeight);
            }
        }
        return this.player;
    }

    private final void initTextureView() {
        if (this.view == null) {
            TextureView textureView = new TextureView(getContext());
            this.view = textureView;
            textureView.setSurfaceTextureListener(this);
            TextureView textureView2 = this.view;
            if (textureView2 != null) {
                textureView2.setOpaque(false);
            }
            addView(this.view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final SquarePlayerPool getPlayerPool() {
        return this.playerPool;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public PlayerState getState() {
        PlayerState state;
        SquarePlayer squarePlayer = this.player;
        return (squarePlayer == null || (state = squarePlayer.getState()) == null) ? PlayerState.Idle : state;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public MediaSource getVideoSource() {
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            return squarePlayer.getVideoSource();
        }
        return null;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer, com.tencent.state.square.media.ISquareRender
    public boolean isDestroying() {
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            return squarePlayer.isDestroying();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        initTextureView();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.displaySurface = surface;
        this.surfaceWidth = width;
        this.surfaceHeight = height;
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.onSurfaceAvailable(surface, width, height);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        this.surfaceWidth = width;
        this.surfaceHeight = height;
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.onSurfaceSizeChanged(width, height);
        }
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void pause() {
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.pause();
        }
    }

    public final void recyclePlayer() {
        SquarePlayerPool squarePlayerPool;
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null && (squarePlayerPool = this.playerPool) != null) {
            squarePlayerPool.recycle(squarePlayer);
        }
        this.player = null;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void release() {
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.release();
        }
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void resume() {
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.resume();
        }
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void setListener(ISquarePlayer.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.setListener(listener);
        }
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void setLoopPlay(boolean isLoopPlay) {
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.setLoopPlay(isLoopPlay);
        }
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void setPlayConfig(PlayConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.setPlayConfig(config);
        }
    }

    public final void setPlayerPool(SquarePlayerPool squarePlayerPool) {
        this.playerPool = squarePlayerPool;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void start(MediaSource source) {
        SquarePlayer checkPlayer;
        Intrinsics.checkNotNullParameter(source, "source");
        if (SquareBase.INSTANCE.getConfig().getCommonUtils().getPerformanceConfig().getForbiddenVideoPlay() || (checkPlayer = checkPlayer()) == null) {
            return;
        }
        checkPlayer.start(source);
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void stop() {
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.stop();
        }
    }

    public SquareVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        this.displaySurface = null;
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.onSurfaceDestroyed(surface);
        }
        recyclePlayer();
        return true;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void reset() {
        this.listener = null;
        this.config = null;
        SquarePlayer squarePlayer = this.player;
        if (squarePlayer != null) {
            squarePlayer.reset();
        }
        removeView(this.view);
        this.view = null;
    }

    public SquareVideoView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, 8, null);
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void start() {
        SquarePlayer checkPlayer;
        if (SquareBase.INSTANCE.getConfig().getCommonUtils().getPerformanceConfig().getForbiddenVideoPlay() || (checkPlayer = checkPlayer()) == null) {
            return;
        }
        checkPlayer.start();
    }

    public /* synthetic */ SquareVideoView(Context context, AttributeSet attributeSet, int i3, SquarePlayerPool squarePlayerPool, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? null : squarePlayerPool);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareVideoView(Context context, AttributeSet attributeSet, int i3, SquarePlayerPool squarePlayerPool) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.playerPool = squarePlayerPool;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }
}

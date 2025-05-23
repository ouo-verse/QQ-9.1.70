package com.tencent.sqshow.zootopia.player;

import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0014\u001a\u00020\u0013H&J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\u0006H&J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0006H&J\b\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\u0006H&J\b\u0010\u001f\u001a\u00020\u0006H&\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/player/c;", "", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "getVideoView", "Lcom/tencent/sqshow/zootopia/player/a;", "listener", "", "d", "c", "Lcom/tencent/sqshow/zootopia/player/b;", "b", "e", "", "isReady", "isPrepared", "", "getPlayUrl", "Lcom/tencent/superplayer/api/ISuperPlayer;", "f", "Lcom/tencent/sqshow/zootopia/player/PlayStatus;", "getCurrentStatus", "url", "startPlay", "isOutputMute", "a", "", "xYaxis", QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, "pause", "reset", "recycle", "destroy", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface c {
    void a(String url, boolean isOutputMute);

    void b(b listener);

    void c(a listener);

    void d(a listener);

    void destroy();

    void e(b listener);

    /* renamed from: f */
    ISuperPlayer getPlayer();

    /* renamed from: getCurrentStatus */
    PlayStatus getCurrStatus();

    /* renamed from: getPlayUrl */
    String getCurrentUrl();

    /* renamed from: getVideoView */
    ISPlayerVideoView getSuperPlayerView();

    boolean isPrepared();

    boolean isReady();

    void pause();

    void recycle();

    void reset();

    void setXYaxis(int xYaxis);

    void startPlay();

    void startPlay(String url);
}

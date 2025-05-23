package com.tencent.mobileqq.qqecommerce.base.video;

import android.view.View;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0011H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0017\u001a\u00020\u000eH&J\b\u0010\u0018\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\fH&J\b\u0010\u001a\u001a\u00020\fH&J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/video/f;", "", "Landroid/view/View;", "getView", "Lcom/tencent/mobileqq/qqecommerce/base/video/c;", "info", "", "b", "start", "pause", "stop", "release", "", com.tencent.luggage.wxa.c8.c.G, "", "mode", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "", "mute", "setMute", "loop", "setLoop", QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, "getState", "getCurrentPositionMs", "getDurationMs", "getFileSizeBytes", "Lcom/tencent/mobileqq/qqecommerce/base/video/d;", "callback", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface f {
    void a(d callback);

    void b(ECVideoInfo info);

    long getCurrentPositionMs();

    long getDurationMs();

    long getFileSizeBytes();

    int getState();

    View getView();

    void pause();

    void release();

    void seek(long pos, int mode);

    void setLoop(boolean loop);

    void setMute(boolean mute);

    void setXYaxis(int mode);

    void start();

    void stop();
}

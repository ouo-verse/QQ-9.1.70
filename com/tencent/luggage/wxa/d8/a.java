package com.tencent.luggage.wxa.d8;

import android.os.Bundle;
import android.view.Surface;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.luggage.wxa.ff.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0010H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0013\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/luggage/wxa/d8/a;", "Lcom/tencent/luggage/wxa/ff/a;", "Landroid/os/Bundle;", "params", "Lcom/tencent/luggage/wxa/ff/h;", "a", "Landroid/view/Surface;", "surface", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, "", "width", "height", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize, "", "sendHandupStop", "sendWeChatStop", "", "isPlaying", "b", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public interface a extends com.tencent.luggage.wxa.ff.a {
    @NotNull
    h a();

    @NotNull
    h a(@Nullable Bundle params);

    boolean b();

    boolean isPlaying();

    void sendHandupStop();

    void sendWeChatStop();

    @NotNull
    h setSurface(@Nullable Surface surface);

    @NotNull
    h setSurfaceSize(int width, int height);
}

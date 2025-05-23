package com.tencent.luggage.wxa.f8;

import android.os.Bundle;
import android.view.Surface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.impl.V2TXLiveDefInner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH&J\b\u0010\u0013\u001a\u00020\tH&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0016\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0017H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0019\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/luggage/wxa/f8/m;", "Lcom/tencent/luggage/wxa/ff/b;", "Landroid/os/Bundle;", "params", "Lcom/tencent/luggage/wxa/ff/h;", "initLivePusher", "Landroid/view/Surface;", "surface", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, "", "width", "height", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize, "", HippyTKDListViewAdapter.X, "y", "setFocusPosition", "value", "setZoom", "getMaxZoom", "", "sendHandupStop", "sendWeChatStop", "", "isPushing", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public interface m extends com.tencent.luggage.wxa.ff.b {
    int getMaxZoom();

    @NotNull
    com.tencent.luggage.wxa.ff.h initLivePusher(@Nullable Bundle params);

    boolean isPushing();

    void sendHandupStop();

    void sendWeChatStop();

    @NotNull
    com.tencent.luggage.wxa.ff.h setFocusPosition(float x16, float y16);

    @NotNull
    com.tencent.luggage.wxa.ff.h setSurface(@Nullable Surface surface);

    @NotNull
    com.tencent.luggage.wxa.ff.h setSurfaceSize(int width, int height);

    @NotNull
    com.tencent.luggage.wxa.ff.h setZoom(int value);
}

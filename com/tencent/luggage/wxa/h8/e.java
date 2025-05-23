package com.tencent.luggage.wxa.h8;

import android.util.Size;
import android.view.Surface;
import com.tencent.luggage.wxa.f8.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&R\u0014\u0010\u0010\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u001d\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001f\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/luggage/wxa/h8/e;", "", "Landroid/view/Surface;", "previewSurface", "", "a", "Landroid/util/Size;", "size", "e", "Lcom/tencent/luggage/wxa/z7/c;", "invokeContext", "", "c", "b", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "livePusherBroker", "Lcom/tencent/luggage/wxa/f8/m;", "()Lcom/tencent/luggage/wxa/f8/m;", "livePusher", "Lcom/tencent/luggage/wxa/h8/b;", "f", "()Lcom/tencent/luggage/wxa/h8/b;", "deviceOrientationChangeListener", "Lcom/tencent/luggage/wxa/h8/c;", "d", "()Lcom/tencent/luggage/wxa/h8/c;", "focusPositionChangeListener", "Lcom/tencent/luggage/wxa/h8/d;", "()Lcom/tencent/luggage/wxa/h8/d;", "gestureScaleListener", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public interface e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\b\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/luggage/wxa/h8/e$a;", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "livePusherBroker", "Lcom/tencent/luggage/wxa/f8/m;", "livePusher", "Lcom/tencent/luggage/wxa/h8/e;", "a", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public interface a {
        @NotNull
        e a(@NotNull LivePusherPluginHandler livePusherBroker, @NotNull m livePusher);
    }

    @NotNull
    /* renamed from: a */
    m getLivePusher();

    void a(@NotNull Size size);

    void a(@NotNull Surface previewSurface);

    boolean a(@NotNull com.tencent.luggage.wxa.z7.c invokeContext);

    @NotNull
    d b();

    void b(@NotNull com.tencent.luggage.wxa.z7.c invokeContext);

    @NotNull
    /* renamed from: c */
    LivePusherPluginHandler getLivePusherBroker();

    void c(@NotNull com.tencent.luggage.wxa.z7.c invokeContext);

    @NotNull
    c d();

    void e();

    @NotNull
    b f();
}

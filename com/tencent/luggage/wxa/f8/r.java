package com.tencent.luggage.wxa.f8;

import android.view.Surface;
import android.view.View;
import com.tencent.luggage.wxa.ag.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/luggage/wxa/f8/r;", "Lcom/tencent/luggage/wxa/a8/c;", "Lcom/tencent/luggage/wxa/f8/q;", "Lcom/tencent/luggage/wxa/i8/c;", "e", "Lcom/tencent/luggage/wxa/ag/i$a;", "c", "Lcom/tencent/luggage/wxa/ag/d;", "a", "Lcom/tencent/luggage/wxa/f8/q;", "videoContainer", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;", "pluginHandler", "<init>", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LivePusherPluginHandler;)V", "d", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class r extends com.tencent.luggage.wxa.a8.c {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final i.a f125516e = b.f125519a;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f125517f = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q videoContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/luggage/wxa/f8/r$a", "Lcom/tencent/luggage/wxa/ag/d;", "", "viewId", "Lcom/tencent/luggage/wxa/yh/b;", "c", "Lcom/tencent/luggage/wxa/yh/c;", "d", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.ag.d {
        @Override // com.tencent.luggage.wxa.ag.d
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.yh.b b(int viewId) {
            com.tencent.luggage.wxa.yh.b bVar = new com.tencent.luggage.wxa.yh.b();
            bVar.setData("livePusherId", Integer.valueOf(viewId));
            return bVar;
        }

        @Override // com.tencent.luggage.wxa.ag.d
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.yh.c a(int viewId) {
            com.tencent.luggage.wxa.yh.c cVar = new com.tencent.luggage.wxa.yh.c();
            cVar.setData("livePusherId", Integer.valueOf(viewId));
            return cVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/luggage/wxa/f8/q;", "videoContainer", "Lcom/tencent/luggage/wxa/ag/i;", "Lcom/tencent/luggage/wxa/i8/c;", "kotlin.jvm.PlatformType", "a", "(Lcom/tencent/luggage/wxa/f8/q;)Lcom/tencent/luggage/wxa/ag/i;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b<OriginVideoContainer extends com.tencent.luggage.wxa.ag.h, PipVideoContainer extends View> implements i.a {

        /* renamed from: a, reason: collision with root package name */
        public static final b<OriginVideoContainer, PipVideoContainer> f125519a = new b<>();

        @Override // com.tencent.luggage.wxa.ag.i.a
        @NotNull
        public final com.tencent.luggage.wxa.ag.i a(@NotNull q videoContainer) {
            Intrinsics.checkNotNullParameter(videoContainer, "videoContainer");
            videoContainer.a((Surface) null);
            return new s(videoContainer);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull LivePusherPluginHandler pluginHandler) {
        super(pluginHandler);
        Intrinsics.checkNotNullParameter(pluginHandler, "pluginHandler");
        this.videoContainer = new q(pluginHandler);
    }

    @Override // com.tencent.luggage.wxa.a8.q
    @NotNull
    public com.tencent.luggage.wxa.ag.d a() {
        return f125517f;
    }

    @Override // com.tencent.luggage.wxa.a8.q
    @NotNull
    public i.a c() {
        return f125516e;
    }

    @Override // com.tencent.luggage.wxa.a8.q
    @NotNull
    /* renamed from: e, reason: from getter and merged with bridge method [inline-methods] */
    public q b() {
        return this.videoContainer;
    }
}

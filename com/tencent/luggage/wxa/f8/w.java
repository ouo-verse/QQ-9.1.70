package com.tencent.luggage.wxa.f8;

import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.rtmp.TXLivePusher;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/luggage/wxa/f8/w;", "", "Lcom/tencent/rtmp/TXLivePusher;", "livePusher", "Lcom/tencent/luggage/wxa/f8/n;", "a", "Lcom/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter;", "livePusherJsAdapter", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f125532a = new w();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/luggage/wxa/f8/w$a", "Lcom/tencent/luggage/wxa/f8/n;", "Lcom/tencent/rtmp/TXLivePusher$VideoCustomProcessListener;", "videoProcessListener", "", "a", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TXLivePusher f125533a;

        public a(TXLivePusher tXLivePusher) {
            this.f125533a = tXLivePusher;
        }

        @Override // com.tencent.luggage.wxa.f8.n
        public void a(@NotNull TXLivePusher.VideoCustomProcessListener videoProcessListener) {
            Intrinsics.checkNotNullParameter(videoProcessListener, "videoProcessListener");
            this.f125533a.setVideoProcessListener(videoProcessListener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/luggage/wxa/f8/w$b", "Lcom/tencent/luggage/wxa/f8/n;", "Lcom/tencent/rtmp/TXLivePusher$VideoCustomProcessListener;", "videoProcessListener", "", "a", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ V2TXLivePusherJSAdapter f125534a;

        public b(V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter) {
            this.f125534a = v2TXLivePusherJSAdapter;
        }

        @Override // com.tencent.luggage.wxa.f8.n
        public void a(@NotNull TXLivePusher.VideoCustomProcessListener videoProcessListener) {
            Intrinsics.checkNotNullParameter(videoProcessListener, "videoProcessListener");
            this.f125534a.setVideoProcessListener(videoProcessListener);
        }
    }

    w() {
    }

    @JvmStatic
    @NotNull
    public static final n a(@NotNull TXLivePusher livePusher) {
        Intrinsics.checkNotNullParameter(livePusher, "livePusher");
        return new a(livePusher);
    }

    @JvmStatic
    @NotNull
    public static final n a(@NotNull V2TXLivePusherJSAdapter livePusherJsAdapter) {
        Intrinsics.checkNotNullParameter(livePusherJsAdapter, "livePusherJsAdapter");
        return new b(livePusherJsAdapter);
    }
}

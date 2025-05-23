package com.tencent.timi.game.liveroom.impl.util;

import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.common.api.AegisLogger;
import com.yolo.esports.download.common.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/util/c;", "", "", "url", "filePath", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "textView", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "j", "Lcom/tencent/timi/game/liveroom/impl/util/c$a;", "callback", "f", "name", "defaultTypeface", "g", "i", "k", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "Lcom/tencent/mobileqq/qqlive/sail/b;", "c", "Lcom/tencent/mobileqq/qqlive/sail/b;", "downloadService", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f378976a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Typeface> cache = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.qqlive.sail.b downloadService = com.tencent.mobileqq.qqlive.sail.b.f272169b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/util/c$a;", "", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "downloadedLength", "totalLength", "onDownloadProgress", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void onDownloadProgress(long downloadedLength, long totalLength);

        void onRspCallback(boolean isSuccess, @NotNull String filePath);
    }

    c() {
    }

    private final void f(String url, a callback) {
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.f390014e = url;
        com.tencent.mobileqq.qqlive.sail.b bVar = downloadService;
        bVar.J0(downloadInfo, new b(callback, url));
        bVar.A3(downloadInfo);
    }

    public static /* synthetic */ Typeface h(c cVar, String str, Typeface DEFAULT, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            DEFAULT = Typeface.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        }
        return cVar.g(str, DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final TextView textView, final Typeface typeface) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.util.b
            @Override // java.lang.Runnable
            public final void run() {
                c.l(textView, typeface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(TextView textView, Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "$typeface");
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String url, String filePath) {
        try {
            Typeface typeface = Typeface.createFromFile(filePath);
            ConcurrentHashMap<String, Typeface> concurrentHashMap = cache;
            Intrinsics.checkNotNullExpressionValue(typeface, "typeface");
            concurrentHashMap.put(url, typeface);
        } catch (Throwable th5) {
            AegisLogger.INSTANCE.e("Audience|QQLiveTypefaceManager", "updateCache", "error:" + th5);
        }
    }

    @NotNull
    public final Typeface g(@NotNull String name, @NotNull Typeface defaultTypeface) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(defaultTypeface, "defaultTypeface");
        ConcurrentHashMap<String, Typeface> concurrentHashMap = cache;
        if (concurrentHashMap.containsKey(name) && (typeface = concurrentHashMap.get(name)) != null) {
            return typeface;
        }
        return defaultTypeface;
    }

    public final void i(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!cache.containsKey(url)) {
            f(url, new C9961c(url));
        }
    }

    public final void k(@Nullable TextView textView, @NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ConcurrentHashMap<String, Typeface> concurrentHashMap = cache;
        if (concurrentHashMap.containsKey(url)) {
            Typeface typeface = concurrentHashMap.get(url);
            if (typeface != null) {
                f378976a.j(textView, typeface);
                return;
            }
            return;
        }
        f(url, new d(url, textView));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/util/c$b", "Lcom/yolo/esports/download/cb/a;", "Lcom/yolo/esports/download/common/DownloadInfo;", "taskInfo", "", "a", "c", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements com.yolo.esports.download.cb.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f378979a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f378980b;

        b(a aVar, String str) {
            this.f378979a = aVar;
            this.f378980b = str;
        }

        @Override // com.yolo.esports.download.cb.a
        public void b(@Nullable DownloadInfo taskInfo) {
            a aVar;
            if (taskInfo != null && (aVar = this.f378979a) != null) {
                aVar.onDownloadProgress(taskInfo.F, taskInfo.G);
            }
        }

        @Override // com.yolo.esports.download.cb.a
        public void c(@Nullable DownloadInfo taskInfo) {
            if (taskInfo != null && taskInfo.H == 0) {
                if (!taskInfo.v()) {
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveTypefaceManager", "downloadTypeface success. url:" + this.f378980b);
                c.downloadService.f3(this);
                a aVar = this.f378979a;
                if (aVar != null) {
                    String str = taskInfo.f390017i;
                    Intrinsics.checkNotNullExpressionValue(str, "taskInfo.fileAbsPath");
                    aVar.onRspCallback(true, str);
                    return;
                }
                return;
            }
            a aVar2 = this.f378979a;
            if (aVar2 != null) {
                aVar2.onRspCallback(false, "");
            }
            c.downloadService.f3(this);
        }

        @Override // com.yolo.esports.download.cb.a
        public void a(@Nullable DownloadInfo taskInfo) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/util/c$c", "Lcom/tencent/timi/game/liveroom/impl/util/c$a;", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "downloadedLength", "totalLength", "onDownloadProgress", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.util.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9961c implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f378981a;

        C9961c(String str) {
            this.f378981a = str;
        }

        @Override // com.tencent.timi.game.liveroom.impl.util.c.a
        public void onRspCallback(boolean isSuccess, @NotNull String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            if (isSuccess) {
                c.f378976a.m(this.f378981a, filePath);
            }
        }

        @Override // com.tencent.timi.game.liveroom.impl.util.c.a
        public void onDownloadProgress(long downloadedLength, long totalLength) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/util/c$d", "Lcom/tencent/timi/game/liveroom/impl/util/c$a;", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "downloadedLength", "totalLength", "onDownloadProgress", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f378982a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f378983b;

        d(String str, TextView textView) {
            this.f378982a = str;
            this.f378983b = textView;
        }

        @Override // com.tencent.timi.game.liveroom.impl.util.c.a
        public void onRspCallback(boolean isSuccess, @NotNull String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            if (isSuccess) {
                c cVar = c.f378976a;
                cVar.m(this.f378982a, filePath);
                Typeface typeface = (Typeface) c.cache.get(this.f378982a);
                if (typeface != null) {
                    cVar.j(this.f378983b, typeface);
                }
            }
        }

        @Override // com.tencent.timi.game.liveroom.impl.util.c.a
        public void onDownloadProgress(long downloadedLength, long totalLength) {
        }
    }
}

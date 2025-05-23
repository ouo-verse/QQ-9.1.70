package com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/k;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/f;", "listener", "", "c", "b", "", "timeMs", "", "tag", "", "assetPath", "Landroid/graphics/Bitmap;", "getBitmapByTime", "a", "", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "Ljava/util/Map;", "listenerCache", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class k implements com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f275344a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, d> listenerCache = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/k$a;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/f;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/f;", "getListener", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/f;", "listener", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/f;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.f listener;

        public a(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.f listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.d
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            this.listener.a(tag, startTimeMs, bitmap);
        }
    }

    k() {
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d
    @Nullable
    public Bitmap a() {
        return ThumbnailProviderManager.f275307a.h();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d
    public void b(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        d remove = listenerCache.remove(Integer.valueOf(listener.hashCode()));
        if (remove != null) {
            ThumbnailProviderManager.f275307a.o(remove);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d
    public void c(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Map<Integer, d> map = listenerCache;
        if (!map.containsKey(Integer.valueOf(listener.hashCode()))) {
            a aVar = new a(listener);
            map.put(Integer.valueOf(listener.hashCode()), aVar);
            ThumbnailProviderManager.f275307a.j(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d
    @Nullable
    public Bitmap getBitmapByTime(long timeMs, @Nullable Object tag, @NotNull String assetPath) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        return ThumbnailProviderManager.f275307a.g(timeMs, tag, assetPath);
    }
}

package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/o;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "listener", "", "b", "c", "", "timeMs", "", "tag", "", "assetPath", "Landroid/graphics/Bitmap;", "getBitmapByTime", "a", "", "", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "Ljava/util/Map;", "listenerCache", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class o implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f319264a = new o();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, e> listenerCache = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/o$a;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "listenerWrapperWeakRef", "listener", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.avatar.meta.refresh.c<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f> listenerWrapperWeakRef;

        public a(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listenerWrapperWeakRef = new com.tencent.qqnt.avatar.meta.refresh.c<>(listener);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.e
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f fVar = this.listenerWrapperWeakRef.get();
            if (fVar != null) {
                fVar.a(tag, startTimeMs, bitmap);
            }
        }
    }

    o() {
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    @Nullable
    public Bitmap a() {
        return ThumbnailProviderManager.f319211a.m();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    public void b(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        int hashCode = listener.hashCode();
        w53.b.f("ThumbnailProviderImpl", "registerListener " + hashCode);
        Integer valueOf = Integer.valueOf(hashCode);
        Map<Integer, e> map = listenerCache;
        if (!map.containsKey(valueOf)) {
            a aVar = new a(listener);
            map.put(Integer.valueOf(listener.hashCode()), aVar);
            ThumbnailProviderManager.f319211a.q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    public void c(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        int hashCode = listener.hashCode();
        w53.b.f("ThumbnailProviderImpl", "unRegisterListener " + hashCode);
        e remove = listenerCache.remove(Integer.valueOf(hashCode));
        if (remove != null) {
            ThumbnailProviderManager.f319211a.x(remove);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    @Nullable
    public Bitmap getBitmapByTime(long timeMs, @Nullable Object tag, @NotNull String assetPath) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        return ThumbnailProviderManager.l(ThumbnailProviderManager.f319211a, timeMs, tag, assetPath, false, 8, null);
    }
}

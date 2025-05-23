package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/p;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/c;", "", "startTimeUs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "b", "timeUs", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/a;", "c", "a", "release", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/j;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/j;", "cache", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getBitmapList$qq_wink_impl_release", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "bitmapList", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/j;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j cache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<BitmapPoint> bitmapList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((BitmapPoint) t16).getTime()), Long.valueOf(((BitmapPoint) t17).getTime()));
            return compareValues;
        }
    }

    public p(@NotNull j cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.cache = cache;
        this.bitmapList = new CopyOnWriteArrayList<>();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.c
    public void a(long timeUs) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.bitmapList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((BitmapPoint) obj).getTime() == timeUs) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        BitmapPoint bitmapPoint = (BitmapPoint) obj;
        if (bitmapPoint != null) {
            this.bitmapList.remove(bitmapPoint);
            Bitmap bitmap = bitmapPoint.getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                w53.b.f("ThumbnailVideoCacheHelper", "bitmap recycle:" + bitmapPoint.getTime());
                bitmap.recycle();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.c
    public void b(long startTimeUs, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        w53.b.f("ThumbnailVideoCacheHelper", "addCover: " + startTimeUs);
        BitmapPoint bitmapPoint = new BitmapPoint(bitmap, startTimeUs);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.bitmapList);
        arrayList.add(bitmapPoint);
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new a());
        }
        this.bitmapList.clear();
        this.bitmapList.addAll(arrayList);
        this.cache.b().put(new LRUKey(this.cache.getAssetPath(), startTimeUs), Integer.valueOf(bitmap.getAllocationByteCount()));
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.c
    @Nullable
    public BitmapPoint c(long timeUs) {
        Object next;
        Iterator<T> it = this.bitmapList.iterator();
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                long abs = Math.abs(((BitmapPoint) next).getTime() - timeUs);
                do {
                    Object next2 = it.next();
                    long abs2 = Math.abs(((BitmapPoint) next2).getTime() - timeUs);
                    if (abs > abs2) {
                        next = next2;
                        abs = abs2;
                    }
                } while (it.hasNext());
            }
        }
        BitmapPoint bitmapPoint = (BitmapPoint) next;
        if (bitmapPoint == null) {
            return null;
        }
        this.cache.b().get(new LRUKey(this.cache.getAssetPath(), timeUs));
        return bitmapPoint;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.c
    public void release() {
        for (BitmapPoint bitmapPoint : this.bitmapList) {
            Bitmap bitmap = bitmapPoint.getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            this.cache.b().remove(new LRUKey(this.cache.getAssetPath(), bitmapPoint.getTime()));
        }
        this.bitmapList.clear();
    }
}

package es;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wink.mosaic.model.MosaicLinePath;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Les/a;", "", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "d", "(Landroid/graphics/Bitmap;)V", "originBitmap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/wink/mosaic/model/MosaicLinePath;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setUnDoList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "unDoList", "setReDoList", "reDoList", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Bitmap originBitmap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<MosaicLinePath> unDoList = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<MosaicLinePath> reDoList = new CopyOnWriteArrayList<>();

    /* renamed from: a, reason: from getter */
    public final Bitmap getOriginBitmap() {
        return this.originBitmap;
    }

    public final CopyOnWriteArrayList<MosaicLinePath> b() {
        return this.reDoList;
    }

    public final CopyOnWriteArrayList<MosaicLinePath> c() {
        return this.unDoList;
    }

    public final void d(Bitmap bitmap) {
        this.originBitmap = bitmap;
    }
}

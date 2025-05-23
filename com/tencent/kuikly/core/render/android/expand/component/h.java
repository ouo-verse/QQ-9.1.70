package com.tencent.kuikly.core.render.android.expand.component;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/h;", "", "Landroid/graphics/NinePatch;", "e", "", "d", "", "f", "width", "a", "height", "b", "Landroid/graphics/drawable/NinePatchDrawable;", "c", "I", "", "Ljava/util/List;", "xRegions", "yRegions", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V", "g", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<Integer> xRegions;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<Integer> yRegions;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Resources resources;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Bitmap bitmap;

    public h(@NotNull Resources resources, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.resources = resources;
        this.bitmap = bitmap;
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
        this.xRegions = new ArrayList();
        this.yRegions = new ArrayList();
    }

    private final byte[] d() {
        if (this.xRegions.isEmpty()) {
            this.xRegions.add(0);
            this.xRegions.add(Integer.valueOf(this.width));
        }
        if (this.yRegions.isEmpty()) {
            this.yRegions.add(0);
            this.yRegions.add(Integer.valueOf(this.height));
        }
        ByteBuffer order = ByteBuffer.allocate(f() * 4).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) this.xRegions.size());
        order.put((byte) this.yRegions.size());
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        Iterator<Integer> it = this.xRegions.iterator();
        while (it.hasNext()) {
            order.putInt(it.next().intValue());
        }
        Iterator<Integer> it5 = this.yRegions.iterator();
        while (it5.hasNext()) {
            order.putInt(it5.next().intValue());
        }
        for (int i3 = 0; i3 < 9; i3++) {
            order.putInt(1);
        }
        byte[] array = order.array();
        Intrinsics.checkNotNullExpressionValue(array, "byteBuffer.array()");
        return array;
    }

    private final NinePatch e() {
        return new NinePatch(this.bitmap, d(), null);
    }

    private final int f() {
        return this.xRegions.size() + 8 + this.yRegions.size() + 9;
    }

    @NotNull
    public final h a(int width) {
        int i3 = (this.width - width) / 2;
        this.xRegions.add(Integer.valueOf(i3));
        this.xRegions.add(Integer.valueOf(i3 + width));
        return this;
    }

    @NotNull
    public final h b(int height) {
        int i3 = (this.height - height) / 2;
        this.yRegions.add(Integer.valueOf(i3));
        this.yRegions.add(Integer.valueOf(i3 + height));
        return this;
    }

    @NotNull
    public final NinePatchDrawable c() {
        return new NinePatchDrawable(this.resources, e());
    }
}

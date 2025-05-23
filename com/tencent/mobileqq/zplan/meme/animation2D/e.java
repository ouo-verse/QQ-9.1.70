package com.tencent.mobileqq.zplan.meme.animation2D;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Pair;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\rH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/e;", "", "Landroid/graphics/Bitmap;", "frameBitmap", "", "frameIndex", "Lkotlin/Pair;", "", "a", "", "pngPath", "encode", "c", "", "b", "", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface e {
    Pair<Long, Integer> a(Bitmap frameBitmap, int frameIndex);

    void b();

    int c();

    byte[] d();

    Pair<Long, Integer> encode(String pngPath);
}

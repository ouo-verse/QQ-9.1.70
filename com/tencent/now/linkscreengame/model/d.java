package com.tencent.now.linkscreengame.model;

import android.graphics.Rect;
import com.tencent.component.appx.utils.AppUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/now/linkscreengame/model/d;", "", "Landroid/graphics/Rect;", "b", "a", "<init>", "()V", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f338503a = new d();

    d() {
    }

    @NotNull
    public final Rect a() {
        Rect b16 = b();
        return new Rect(0, b16.top, b16.right - b16.left, b16.bottom);
    }

    @NotNull
    public final Rect b() {
        double d16;
        int dip2px = AppUtils.UI.dip2px(145.0f) + AppUtils.UI.getStatusBarHeight();
        int i3 = AppUtils.UI.getScreenMetrics().widthPixels;
        if (AppUtils.UI.getScreenMetrics().heightPixels > 2000) {
            d16 = 1.78d;
        } else {
            d16 = 1.44d;
        }
        int i16 = i3 / 2;
        Rect rect = new Rect();
        rect.set(i16, dip2px, i3, ((int) (i16 * d16)) + dip2px);
        return rect;
    }
}

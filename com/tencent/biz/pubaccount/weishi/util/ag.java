package com.tencent.biz.pubaccount.weishi.util;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/ag;", "", "", "colorId", "a", "resId", "", "c", "Landroid/graphics/drawable/Drawable;", "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    public static final ag f81700a = new ag();

    ag() {
    }

    @JvmStatic
    public static final int a(int colorId) {
        return BaseApplicationImpl.getApplication().getResources().getColor(colorId);
    }

    @JvmStatic
    public static final Drawable b(int resId) {
        return BaseApplicationImpl.getApplication().getResources().getDrawable(resId);
    }

    @JvmStatic
    public static final String c(int resId) {
        String string = BaseApplicationImpl.getApplication().getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getApplication().getString(resId)");
        return string;
    }
}

package com.tencent.biz.pubaccount.weishi.util;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.BaseImageUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/u;", "", "Landroid/graphics/Bitmap;", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f81796a = new u();

    u() {
    }

    @JvmStatic
    public static final Bitmap a() {
        Bitmap defaultFaceBitmap = BaseImageUtil.getDefaultFaceBitmap();
        Intrinsics.checkNotNullExpressionValue(defaultFaceBitmap, "getDefaultFaceBitmap()");
        return defaultFaceBitmap;
    }
}

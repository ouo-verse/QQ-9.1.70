package com.qzone.reborn.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/util/m;", "", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f59551a = new m();

    m() {
    }

    public final Drawable a(Context context) {
        if (context == null) {
            context = BaseApplication.getContext();
        }
        Intrinsics.checkNotNull(context);
        return new ColorDrawable(context.getResources().getColor(R.color.qui_common_fill_standard_primary));
    }

    public final Drawable b(Context context) {
        if (context == null) {
            context = BaseApplication.getContext();
        }
        Intrinsics.checkNotNull(context);
        return new ColorDrawable(context.getResources().getColor(R.color.qui_common_fill_standard_primary));
    }
}

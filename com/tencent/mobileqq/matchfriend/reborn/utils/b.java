package com.tencent.mobileqq.matchfriend.reborn.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/b;", "", "", "b", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "a", "c", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f245467a = new b();

    b() {
    }

    public final Drawable a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = context.getResources().getDrawable(b());
        Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDra\u2026ble(getBgSelectorResId())");
        return drawable;
    }

    public final int b() {
        return QQTheme.isNowThemeIsNight() ? R.drawable.f3t : R.drawable.f3s;
    }

    public final int c() {
        return QQTheme.isNowThemeIsNight() ? R.drawable.f3x : R.drawable.f3w;
    }
}

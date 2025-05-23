package com.tencent.mobileqq.vas.vipicon.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.vas.vipicon.api.ILoverVipIconDrawable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/impl/LoverVipIconDrawableImpl;", "Lcom/tencent/mobileqq/vas/vipicon/api/ILoverVipIconDrawable;", "()V", "getDrawable", "Landroid/graphics/drawable/Drawable;", "size", "", "id", "level", "letters", "", "", "vas_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class LoverVipIconDrawableImpl implements ILoverVipIconDrawable {
    @Override // com.tencent.mobileqq.vas.vipicon.api.ILoverVipIconDrawable
    @NotNull
    public Drawable getDrawable(int size, int id5, int level, @NotNull List<String> letters) {
        Intrinsics.checkNotNullParameter(letters, "letters");
        com.tencent.mobileqq.vas.vipicon.e eVar = new com.tencent.mobileqq.vas.vipicon.e(size, size, id5, level, letters, null, 32, null);
        eVar.F(false);
        return eVar;
    }
}

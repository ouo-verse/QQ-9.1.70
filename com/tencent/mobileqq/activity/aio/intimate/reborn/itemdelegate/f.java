package com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import j61.IntimateBaseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\r\u001a\u00020\fH\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/f;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/IntimateCompatBaseItemDelegate;", "Lj61/a;", "model", "", "b", "Landroid/content/Context;", "context", "Landroid/view/View;", "d", "Landroid/graphics/drawable/Drawable;", tl.h.F, "Landroid/view/ViewGroup$MarginLayoutParams;", "i", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f extends IntimateCompatBaseItemDelegate {
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h
    public boolean b(@NotNull IntimateBaseModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @NotNull
    public View d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new View(context);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @Nullable
    protected Drawable h(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @NotNull
    protected ViewGroup.MarginLayoutParams i() {
        return new ViewGroup.MarginLayoutParams(-1, ViewUtils.dpToPx(44.0f) + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
    }
}

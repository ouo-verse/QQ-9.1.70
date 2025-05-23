package com.tencent.mobileqq.proavatar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JZ\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/proavatar/c;", "", "Lcom/tencent/qqnt/avatar/layer/d;", "curLayer", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Rect;", "bounds", "Landroid/graphics/Paint;", "paint", "Lcom/tencent/mobileqq/proavatar/k;", "viewConfig", "Lkotlin/Function0;", "", "drawSelf", "drawableInvalidateSelf", "", "a", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface c {
    boolean a(@NotNull com.tencent.qqnt.avatar.layer.d<? extends Object> curLayer, @NotNull Canvas canvas, @NotNull Rect bounds, @Nullable Paint paint, @Nullable k viewConfig, @NotNull Function0<Unit> drawSelf, @NotNull Function0<Unit> drawableInvalidateSelf);
}

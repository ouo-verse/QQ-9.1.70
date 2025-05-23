package com.tencent.state.square;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/ISquareOnlineStatusHelper;", "", "getBatteryCapacity", "", "getBatteryDrawable", "Landroid/graphics/Bitmap;", "batteryCapacity", "type", "getDiyStatusDrawable", "Landroid/graphics/drawable/Drawable;", "id", "isBatteryPowerConnect", "", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareOnlineStatusHelper {
    int getBatteryCapacity();

    @NotNull
    Bitmap getBatteryDrawable(int batteryCapacity, int type);

    @Nullable
    Drawable getDiyStatusDrawable(int id5, int type);

    boolean isBatteryPowerConnect();
}

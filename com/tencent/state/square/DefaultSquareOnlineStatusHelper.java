package com.tencent.state.square;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/DefaultSquareOnlineStatusHelper;", "Lcom/tencent/state/square/ISquareOnlineStatusHelper;", "()V", "getBatteryCapacity", "", "getBatteryDrawable", "Landroid/graphics/Bitmap;", "batteryCapacity", "type", "getDiyStatusDrawable", "Landroid/graphics/drawable/Drawable;", "id", "isBatteryPowerConnect", "", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultSquareOnlineStatusHelper implements ISquareOnlineStatusHelper {
    private static final String TAG = "StatusHelper";

    @Override // com.tencent.state.square.ISquareOnlineStatusHelper
    public int getBatteryCapacity() {
        return 0;
    }

    @Override // com.tencent.state.square.ISquareOnlineStatusHelper
    @NotNull
    public Bitmap getBatteryDrawable(int batteryCapacity, int type) {
        SquareBaseKt.getSquareLog().d(TAG, "getBatteryDrawable");
        Bitmap createBitmap = Bitmap.createBitmap(30, 30, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-7829368);
        String valueOf = String.valueOf(batteryCapacity);
        Paint paint = new Paint();
        paint.setTextSize(10.0f);
        paint.setColor(-16777216);
        Unit unit = Unit.INSTANCE;
        canvas.drawText(valueOf, 7.0f, 18.0f, paint);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(30, \u2026)\n            }\n        }");
        return createBitmap;
    }

    @Override // com.tencent.state.square.ISquareOnlineStatusHelper
    @Nullable
    public Drawable getDiyStatusDrawable(int id5, int type) {
        return null;
    }

    @Override // com.tencent.state.square.ISquareOnlineStatusHelper
    public boolean isBatteryPowerConnect() {
        return false;
    }
}

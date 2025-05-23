package com.tencent.qqnt.robot.api.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.graphics.drawable.DrawableKt;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.component.qrcode.f;
import com.tencent.mobileqq.component.qrcode.i;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.robot.api.IRobotSharePreviewApi;
import com.tencent.robot.qrcode.widget.RobotQRCodeLoadingComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xx3.a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J2\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/robot/api/impl/RobotSharePreviewApiImpl;", "Lcom/tencent/qqnt/robot/api/IRobotSharePreviewApi;", "()V", "drawLogo", "", PM.CANVAS, "Landroid/graphics/Canvas;", "scale", "", "color", "", "generateBitmap", "Landroid/graphics/Bitmap;", "width", "height", "getIconAndTipsBitmap", "getRobotBottomLineText", "Lkotlin/Pair;", "", "uin", "name", "getRobotFaceDrawable", "Landroid/graphics/drawable/Drawable;", "robotUin", "getRobotQRCodeBitmap", "url", "size", "isPureColor", "", "bgColor", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotSharePreviewApiImpl implements IRobotSharePreviewApi {
    private final void drawLogo(Canvas canvas, float scale, int color) {
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        int dpToPx = (int) (ViewUtils.dpToPx(10.0f) * scale);
        Drawable logoDrawable = BaseApplication.context.getResources().getDrawable(R.drawable.qui_robot);
        Intrinsics.checkNotNullExpressionValue(logoDrawable, "logoDrawable");
        Bitmap bitmap$default = DrawableKt.toBitmap$default(logoDrawable, dpToPx, dpToPx, null, 4, null);
        float width = (canvas.getWidth() - dpToPx) / 2;
        canvas.drawBitmap(bitmap$default, width, width, paint);
    }

    private final Bitmap generateBitmap(int width, int height) {
        try {
            return Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        } catch (Throwable unused) {
            System.gc();
            try {
                return Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }

    @Override // com.tencent.qqnt.robot.api.IRobotSharePreviewApi
    @Nullable
    public Bitmap getIconAndTipsBitmap(int width, int height) {
        Drawable drawable = BaseApplication.context.getDrawable(R.drawable.f162402lj4);
        if (drawable == null) {
            return null;
        }
        return DrawableKt.toBitmap$default(drawable, width, height, null, 4, null);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotSharePreviewApi
    @NotNull
    public Pair<String, String> getRobotBottomLineText(@NotNull String uin, @Nullable String name) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (name != null && name.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            name = "\u673a\u5668\u4eba";
        }
        return new Pair<>("\u957f\u6309\u8bc6\u522b", "\u8ddf\u300c" + name + "\u300d\u804a\u4e00\u804a");
    }

    @Override // com.tencent.qqnt.robot.api.IRobotSharePreviewApi
    @Nullable
    public Drawable getRobotFaceDrawable(@NotNull String robotUin) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        AppInterface appInterface2 = appInterface;
        if (appInterface2 == null) {
            return defaultDrawable;
        }
        return FaceDrawable.getFaceDrawable(appInterface2, 1, 100, robotUin, 3, defaultDrawable, defaultDrawable, null);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotSharePreviewApi
    @Nullable
    public Bitmap getRobotQRCodeBitmap(@NotNull String url, int size, int color, boolean isPureColor, int bgColor) {
        List listOf;
        Intrinsics.checkNotNullParameter(url, "url");
        int dpToPx = ViewUtils.dpToPx(288.0f);
        Bitmap generateBitmap = generateBitmap(dpToPx, dpToPx);
        if (generateBitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(generateBitmap);
        canvas.drawColor(bgColor);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RobotQRCodeLoadingComponent robotQRCodeLoadingComponent = new RobotQRCodeLoadingComponent(context, null, 0, 6, null);
        robotQRCodeLoadingComponent.setChain(url, true);
        if (robotQRCodeLoadingComponent.getResCode() != 0) {
            return null;
        }
        robotQRCodeLoadingComponent.setLogoResParams(new i(R.drawable.qui_robot, null, null, 0, 14, null));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(dpToPx, 1073741824);
        robotQRCodeLoadingComponent.measure(makeMeasureSpec, makeMeasureSpec);
        if (isPureColor) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{new f(0.0d, 0.0d, 0.0d), new f(0.0d, 0.0d, 0.0d), new f(0.0d, 0.0d, 0.0d)});
            robotQRCodeLoadingComponent.setRefreshQRCodeBgColor(color, new a(listOf));
        } else {
            RobotQRCodeLoadingComponent.setRefreshQRCodeBgColor$default(robotQRCodeLoadingComponent, color, null, 2, null);
        }
        robotQRCodeLoadingComponent.layout(0, 0, dpToPx, dpToPx);
        robotQRCodeLoadingComponent.e(canvas);
        drawLogo(canvas, dpToPx / size, bgColor);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(generateBitmap, size, size, true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "Bitmap.createScaledBitma\u2026s, width, height, filter)");
        return createScaledBitmap;
    }
}

package com.tencent.mobileqq.qwallet;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/d;", "", "Landroid/content/Context;", "context", "", "b", "c", "Landroid/util/Pair;", "", "a", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f277142a = new d();

    d() {
    }

    private final boolean b(Context context) {
        Integer screenWidth = (Integer) a(context).first;
        Integer screenHeight = (Integer) a(context).second;
        Intrinsics.checkNotNullExpressionValue(screenWidth, "screenWidth");
        boolean z16 = false;
        if (screenWidth.intValue() > 0) {
            Intrinsics.checkNotNullExpressionValue(screenHeight, "screenHeight");
            if (screenHeight.intValue() > 0) {
                float intValue = (screenWidth.intValue() * 1.0f) / screenHeight.intValue();
                float f16 = 1 / 0.71f;
                if (0.71f <= intValue && intValue <= f16) {
                    z16 = true;
                }
                QLog.i("QWalletPadUtils", 1, "isFolderScreenOpenMode:" + z16 + ", curRatio:" + intValue);
            }
        }
        return z16;
    }

    @NotNull
    public final Pair<Integer, Integer> a(@NotNull Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        if (systemService instanceof WindowManager) {
            windowManager = (WindowManager) systemService;
        } else {
            windowManager = null;
        }
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0025, code lost:
    
        if (b(r0) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c() {
        boolean z16;
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(a16, "getDeviceType(MobileQQ.getContext())");
        if (a16 != DeviceType.TABLET) {
            if (a16 == DeviceType.FOLD) {
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            }
            z16 = false;
            QLog.d("QWalletPadUtils", 1, "isPadOrFoldDevice: " + z16 + " ,model: " + ah.s());
            return z16;
        }
        z16 = true;
        QLog.d("QWalletPadUtils", 1, "isPadOrFoldDevice: " + z16 + " ,model: " + ah.s());
        return z16;
    }
}

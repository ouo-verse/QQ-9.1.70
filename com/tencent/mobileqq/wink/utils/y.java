package com.tencent.mobileqq.wink.utils;

import android.content.Context;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import common.config.service.QzoneConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.Config;
import org.light.LightEngine;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/y;", "", "", "mode", "Lorg/light/Config$DeviceAbilityMode;", "g", "", tl.h.F, "j", "i", "Landroid/content/Context;", "context", "", "b", "", "soPath", "e", "jsonDirPath", "d", "a", "f", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final y f326739a = new y();

    y() {
    }

    private final Config.DeviceAbilityMode g(int mode) {
        if (mode != 1) {
            if (mode != 2) {
                return Config.DeviceAbilityMode.DEVICE_ABILITY_DEFAULT;
            }
            return Config.DeviceAbilityMode.DEVICE_ABILITY_FORCE_CLOSE;
        }
        return Config.DeviceAbilityMode.DEVICE_ABILITY_FORCE_OPEN;
    }

    private final boolean h() {
        if (QzoneConfig.getVideoPlayOptimSwitch() != 2 && QzoneConfig.getAutoImageCropSwitch() != 2 && (!j() || !i())) {
            return false;
        }
        return true;
    }

    private final boolean i() {
        ar arVar = ar.f326685a;
        if (arVar.e("opt.video_lag", 0) == 0 && arVar.e("opt.img_auto_crop", 0) == 0) {
            return false;
        }
        return true;
    }

    private final boolean j() {
        return false;
    }

    public final void a() {
        ms.a.f("TavCutAuthUtil", "initAudioSeekSyncMode mode:" + g(QzoneConfig.getAudioSeekSwitch()));
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ms.a.f("TavCutAuthUtil", "tavcut light engine auth ret = " + LightEngine.initAuth(context, "", "lightsdk_qq", WinkContext.Companion.j(WinkContext.INSTANCE, false, 1, null)));
    }

    public final void c() {
        int autoImageCropSwitch = QzoneConfig.getAutoImageCropSwitch();
        ms.a.f("TavCutAuthUtil", "initAutoCropImageMode:" + autoImageCropSwitch);
        Config.setDeviceAbilityMode("opt.img_auto_crop", g(autoImageCropSwitch));
    }

    public final void d(@Nullable String jsonDirPath) {
        if (jsonDirPath != null) {
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            LightEngine.initDeviceConfig(jsonDirPath + "assets" + File.separator + "device_config.json", account);
            ms.a.f("TavCutAuthUtil", "initDeviceJson path = " + jsonDirPath + " \uff0ccount=" + account);
        }
    }

    public final void e(@Nullable String soPath) {
        if (h()) {
            d(soPath);
            f();
            a();
            c();
        }
    }

    public final void f() {
        Config.DeviceAbilityMode g16 = g(QzoneConfig.getVideoPlayOptimSwitch());
        ms.a.f("TavCutAuthUtil", "initVideoPlayOpt mode:" + g16);
        Config.setDeviceAbilityMode("opt.video_lag", g16);
    }
}

package com.tencent.mobileqq.onlinestatus.manager;

import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.onlinestatus.processor.OnlineStatusDNDBannerProcessor;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/manager/l;", "", "Lmqq/app/AppRuntime$Status;", "status", "", "b", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "e", "a", "f", "d", "c", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f255972a = new l();

    l() {
    }

    private final long a() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong("key_last_set_dnd_status_time", 0L);
    }

    private final boolean b(AppRuntime.Status status) {
        boolean z16;
        boolean z17 = false;
        if (status != AppRuntime.Status.dnd) {
            e(0L);
            return false;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("101443", "");
        if (loadAsString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("OnlineStatusDNDManager", 1, "[needShowBanner]config is empty.");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            int optInt = new JSONObject(loadAsString).optInt("show_time");
            if (a() == 0) {
                e(currentTimeMillis);
            } else if ((currentTimeMillis - a()) / 1000 > optInt) {
                z17 = true;
            }
        } catch (JSONException e16) {
            QLog.e("OnlineStatusDNDManager", 1, "[needShowBanner] parse config error. ", e16);
        }
        return z17;
    }

    private final void d() {
        BannerManager l3 = BannerManager.l();
        OnlineStatusDNDBannerProcessor.Companion companion = OnlineStatusDNDBannerProcessor.INSTANCE;
        if (l3.o(companion.a())) {
            QLog.d("OnlineStatusDNDManager", 1, "[removeBanner]");
            BannerManager.l().O(companion.a(), -1, null);
        }
    }

    private final void e(long currentTime) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeLong("key_last_set_dnd_status_time", currentTime);
    }

    private final void f() {
        BannerManager.l().O(OnlineStatusDNDBannerProcessor.INSTANCE.a(), 2, null);
    }

    public final void c(@Nullable AppRuntime.Status status) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101443", false)) {
            QLog.w("OnlineStatusDNDManager", 1, "[refreshBanner] isSwitchOn=false");
            d();
            return;
        }
        if (status != null && status != AppRuntime.Status.offline) {
            if (b(status)) {
                QLog.d("OnlineStatusDNDManager", 1, "[refreshBanner] showBanner " + status);
                f();
                return;
            }
            d();
            return;
        }
        QLog.d("OnlineStatusDNDManager", 1, "[refreshBanner] status is offline");
    }
}

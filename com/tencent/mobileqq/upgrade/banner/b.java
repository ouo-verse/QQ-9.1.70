package com.tencent.mobileqq.upgrade.banner;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.biz.qui.noticebar.e;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.chats.biz.z;
import com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.q;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.mobileqq.upgrade.n;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u0010\u001a\u00020\nH\u0007J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0011H\u0007J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/upgrade/banner/b;", "", "Lmqq/app/AppRuntime;", "app", "", "d", "Lcom/tencent/biz/qui/noticebar/e;", "c", "bar", "msgText", "", "l", "b", "", "timestamp", "i", h.F, "", "showInstallBannerOnly", "j", "hideUpgradeBanner", "f", "", "target", "e", "g", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f306275a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63093);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f306275a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final e b(e bar) {
        int i3;
        BaseApplication baseApplication = BaseApplication.context;
        e icon = bar.d(baseApplication.getColor(R.color.qui_common_text_primary)).setIcon(R.drawable.mrt);
        ColorStateList colorStateList = AppCompatResources.getColorStateList(baseApplication, R.color.qui_common_text_link);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "getColorStateList(contex\u2026lor.qui_common_text_link)");
        icon.setLinkTextColor(colorStateList);
        if (QQTheme.isNowThemeIsNight()) {
            i3 = R.drawable.mrv;
        } else {
            i3 = R.drawable.mru;
        }
        Drawable drawable = ResourcesCompat.getDrawable(baseApplication.getResources(), i3, null);
        Drawable drawable2 = ResourcesCompat.getDrawable(baseApplication.getResources(), R.drawable.qui_close_icon_secondary_01_selector, null);
        if (drawable != null && drawable2 != null) {
            bar.l(drawable2).h(drawable);
        }
        return bar;
    }

    @JvmStatic
    @NotNull
    public static final e c() {
        b bVar = f306275a;
        QUINoticeBarManager a16 = QUINoticeBarManager.INSTANCE.a();
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return bVar.b(QUINoticeBarManager.j(a16, context, null, 2, null));
    }

    @JvmStatic
    @Nullable
    public static final String d(@Nullable AppRuntime app) {
        NewUpgradeConfig newUpgradeConfig;
        NewUpgradeConfig.a aVar;
        String str;
        NewUpgradeConfig newUpgradeConfig2;
        NewUpgradeConfig.a aVar2;
        String str2;
        if (!(app instanceof QQAppInterface)) {
            return null;
        }
        UpgradeDetailWrapper j3 = k.i().j();
        if (!ConfigHandler.e3((QQAppInterface) app)) {
            if (j3 == null || (newUpgradeConfig2 = j3.f306174i) == null || (aVar2 = newUpgradeConfig2.dialog) == null || (str2 = aVar2.f306161m) == null) {
                return HardCodeUtil.qqStr(R.string.iau);
            }
            return str2;
        }
        if (j3 == null || (newUpgradeConfig = j3.f306174i) == null || (aVar = newUpgradeConfig.dialog) == null || (str = aVar.f306160l) == null) {
            return HardCodeUtil.qqStr(R.string.f237467h5);
        }
        return str;
    }

    private final boolean e(int target) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        int i3 = fromV2.getInt("key_yellow_bar_close_click", -1);
        QLog.d("UpgradeController_UpgradeBanner", 1, "show bar, hasBannerClosedClicked, current:" + i3 + ", target:" + target);
        if (i3 == target) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void f(boolean hideUpgradeBanner) {
        MqqHandler handler;
        if (hideUpgradeBanner) {
            BannerManager.l().O(UpgradeBannerProcessor.f185277e, 0, null);
        }
        BannerManager.l().O(InstallUpgradeBannerProcessor.f185222e, 0, null);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if ((runtime instanceof AppInterface) && (handler = ((AppInterface) runtime).getHandler(Conversation.class)) != null) {
            handler.obtainMessage(Conversation.MSG_INSTALL_UPGRADE_BAR_HIDE).sendToTarget();
        }
    }

    private final boolean g() {
        UpgradeDetailWrapper j3 = k.i().j();
        if (j3.f306174i != null && j3.f306170d != null) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105527", false);
            if (e(j3.f306170d.iNewTimeStamp) && !isSwitchOn) {
                QLog.d("UpgradeController_UpgradeBanner", 1, "show bar, user has ever closed");
                return false;
            }
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            long j16 = fromV2.getLong("key_yellow_bar_last_show", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j16 <= j3.f306174i.dialog.f306159k * 86400000) {
                QLog.d("UpgradeController_UpgradeBanner", 1, "show bar, not match min gap");
                return false;
            }
            i(currentTimeMillis);
            return true;
        }
        QLog.d("UpgradeController_UpgradeBanner", 1, "show bar, wrapper params is null");
        return false;
    }

    @JvmStatic
    public static final void h() {
        UpgradeDetailWrapper j3 = k.i().j();
        if (n.c(j3)) {
            QLog.d("UpgradeController_UpgradeBanner", 1, "markBannerCloseClicked, dialog not reach max shown times");
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putInt("key_yellow_bar_close_click", j3.f306170d.iNewTimeStamp);
        QLog.d("UpgradeController_UpgradeBanner", 1, "markBannerCloseClicked, " + j3.f306170d.iNewTimeStamp);
    }

    @JvmStatic
    public static final void i(long timestamp) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putLong("key_yellow_bar_last_show", timestamp);
    }

    @JvmStatic
    public static final boolean j(boolean showInstallBannerOnly) {
        final boolean z16;
        int k3 = k.i().k();
        QLog.d("UpgradeController_UpgradeBanner", 1, "showBanner downloadState=", Integer.valueOf(k3));
        if (k3 == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (showInstallBannerOnly && !z16) {
            QLog.d("UpgradeController_UpgradeBanner", 1, "showBanner, only show install banner");
            return false;
        }
        if (!BannerManager.l().p()) {
            QLog.d("UpgradeController_UpgradeBanner", 1, "showBanner, banner manager is not init");
            z.E = true;
            return false;
        }
        if (!f306275a.g()) {
            QLog.d("UpgradeController_UpgradeBanner", 1, "showBanner, no need show more");
            return false;
        }
        QLog.d("UpgradeController_UpgradeBanner", 1, "showBanner, indeed");
        q.g(new Runnable() { // from class: com.tencent.mobileqq.upgrade.banner.a
            @Override // java.lang.Runnable
            public final void run() {
                b.k(z16);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(boolean z16) {
        int i3;
        if (z16) {
            i3 = InstallUpgradeBannerProcessor.f185222e;
        } else {
            i3 = UpgradeBannerProcessor.f185277e;
        }
        BannerManager.l().D(i3, 3000);
    }

    @JvmStatic
    public static final void l(@NotNull e bar, @Nullable String msgText) {
        Intrinsics.checkNotNullParameter(bar, "bar");
        if (msgText != null) {
            bar.setMsg(msgText);
        }
        f306275a.b(bar);
    }
}

package no4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.util.u;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.WebAccelerator;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.web.business.api.race.LivingRaceNativeEvent;
import com.tencent.timi.game.web.business.api.race.LivingRoomInfo;
import com.tencent.timi.game.web.business.impl.common.TimiBrowserActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mo4.b;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import po4.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lno4/a;", "Llo4/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;", "livingRoomInfo", "", "X", "Landroid/content/Context;", "context", "Y", "init", "o2", "K1", "y1", "Z1", "Lmo4/b;", "C2", "Lcom/tencent/timi/game/web/business/api/race/LivingRaceNativeEvent;", "event", "i2", "no4/a$a", "a", "Lno4/a$a;", "webProcessListener", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements lo4.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C10856a webProcessListener = new C10856a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"no4/a$a", "Lcom/tencent/mobileqq/webview/util/u;", "", "realStartProcess", "", "onResult", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: no4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10856a implements u {
        C10856a() {
        }

        @Override // com.tencent.mobileqq.webview.util.u
        public void onResult(boolean realStartProcess) {
            l.b("WebBusinessServiceImpl ", "webProcessListener " + realStartProcess);
        }
    }

    @Override // lo4.a
    @NotNull
    public b C2() {
        return b.INSTANCE.a();
    }

    @Override // lo4.a
    public void K1() {
        if (!((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {
            IWebProcessManagerService iWebProcessManagerService = null;
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime != null) {
                iWebProcessManagerService = (IWebProcessManagerService) waitAppRuntime.getRuntimeService(IWebProcessManagerService.class, "");
            }
            if (iWebProcessManagerService != null) {
                iWebProcessManagerService.startWebProcess(34, this.webProcessListener);
            }
        }
    }

    @Override // lo4.a
    public void X(@NotNull Activity activity, @NotNull String url, @Nullable LivingRoomInfo livingRoomInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        int px2dp = (int) ba.px2dp(activity, (ba.getScreenWidth(activity) * 565.0f) / 375.0f);
        Intent intent = new Intent(activity, (Class<?>) TimiBrowserActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("tg_data_live_room_info", livingRoomInfo);
        intent.putExtra("tg_data_height", px2dp);
        intent.putExtra("tg_data_from", "tg_timi_browser_from_inscription");
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
        activity.startActivity(intent);
    }

    @Override // lo4.a
    public void Y(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        TimiBrowserActivity.Z2(context, url);
    }

    @Override // lo4.a
    public void Z1(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        WebAccelerateHelper.getInstance().preGetKey(url, new Intent(), null);
        WebAccelerateHelper.getInstance().preFetchResource(url);
        WebAccelerator.preConnect(BaseApplication.getContext(), url, 1, true);
    }

    @Override // lo4.a
    public void i2(@NotNull LivingRaceNativeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        j.INSTANCE.a().b(event);
    }

    @Override // lo4.a
    public void y1(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
    }
}

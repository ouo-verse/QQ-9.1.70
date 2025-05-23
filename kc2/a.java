package kc2;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAgeSelectionApi;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0087D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0087D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lkc2/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", MiniChatConstants.MINI_APP_SCREEN_RECORD_LAUNCH_FROM, "", "b", "url", "", "launchScene", "a", "I", "REQUEST_CODE_BIRTHDAY", "c", "DEFAULT_CONSTELLATION", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f412010a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int REQUEST_CODE_BIRTHDAY = 1040;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int DEFAULT_CONSTELLATION = 0;

    a() {
    }

    public final void a(@NotNull Activity activity, @Nullable String url, int launchScene) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (QLog.isColorLevel()) {
            QLog.d("ConstellationLauncher", 2, "launchMiniProgram: called. ", "url: " + url + "  launchScene: " + launchScene);
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, url, launchScene, null, null);
    }

    public final void b(@NotNull Activity activity, @NotNull String launchFrom) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(launchFrom, "launchFrom");
        Intent intent = new Intent();
        if (MobileQQ.sProcessId == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            int i3 = (int) ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).initCard(peekAppRuntime, peekAppRuntime.getCurrentAccountUin()).lBirthday;
            if (QLog.isColorLevel()) {
                QLog.d("ConstellationLauncher", 2, "launchSelectAge: called. ", "{card.lBirthday}: " + i3);
            }
            intent.putExtra("param_birthday", i3);
            intent.putExtra("param_launch_from", launchFrom);
            ((IAgeSelectionApi) QRoute.api(IAgeSelectionApi.class)).startAgeSelectionActivity(activity, intent, REQUEST_CODE_BIRTHDAY);
        }
    }
}

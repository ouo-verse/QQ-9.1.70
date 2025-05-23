package kc2;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tencent.im.onlinestatus.OnlineStatusExtInfo$ZodiacBizInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011JH\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0012"}, d2 = {"Lkc2/d;", "", "Lmqq/app/AppRuntime;", "app", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "", WadlProxyConsts.KEY_JUMP_URL, "todayTrend", "tomorrowTrend", "todayDate", "luckyColor", "luckyNum", "", "b", "a", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f412021a = new d();

    d() {
    }

    private final void b(AppRuntime app, int statusId, String jumpUrl, String todayTrend, String tomorrowTrend, String todayDate, String luckyColor, String luckyNum) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtensionBizInfoHelper", 2, "requestSetConstellationExtInfo: called. ", "statusId: " + statusId + "  todayTrend: " + todayTrend + "  jumpUrl: " + jumpUrl);
        }
        Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) app).getBusinessHandler(OnlineStatusHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler");
        OnlineStatusHandler onlineStatusHandler = (OnlineStatusHandler) businessHandler;
        OnlineStatusExtInfo$ZodiacBizInfo onlineStatusExtInfo$ZodiacBizInfo = new OnlineStatusExtInfo$ZodiacBizInfo();
        onlineStatusExtInfo$ZodiacBizInfo.string_miniapp.set(jumpUrl);
        onlineStatusExtInfo$ZodiacBizInfo.string_today_trend.set(todayTrend);
        onlineStatusExtInfo$ZodiacBizInfo.string_tomorrow_trend.set(tomorrowTrend);
        onlineStatusExtInfo$ZodiacBizInfo.string_today_date.set(todayDate);
        if (!TextUtils.isEmpty(luckyColor)) {
            onlineStatusExtInfo$ZodiacBizInfo.string_lucky_color.set(luckyColor);
        }
        if (!TextUtils.isEmpty(luckyNum)) {
            onlineStatusExtInfo$ZodiacBizInfo.string_lucky_number.set(luckyNum);
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray("ExtInfo", onlineStatusExtInfo$ZodiacBizInfo.toByteArray());
        bundle.putInt("StatusId", statusId);
        onlineStatusHandler.b3(3, bundle, null);
    }

    public final void a(@NotNull AppRuntime app, int statusId) {
        Intrinsics.checkNotNullParameter(app, "app");
        String uin = app.getCurrentAccountUin();
        String c16 = c.c(app);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        b(app, statusId, c16, c.w(uin), c.z(uin), c.g(), c.k(uin), c.l(uin));
    }
}

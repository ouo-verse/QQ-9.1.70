package com.tencent.timi.game.liveroom.impl.room.userlevel;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserPayLevelData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/j;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f378617a = new j();

    j() {
    }

    private final void b(Activity activity) {
        String str;
        int screenWidth;
        UserPayLevelData g16 = i.f378614a.g();
        if (g16 != null) {
            str = g16.getPrivilegeJumpUrl();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            AegisLogger.INSTANCE.e("Gift|UserLevelWebViewDialogUtils", "privilegeJumpUrl", "invalid url:" + str);
            return;
        }
        Bundle bundle = new Bundle();
        if (activity.getRequestedOrientation() != 0 && 8 != activity.getRequestedOrientation()) {
            screenWidth = ScreenUtils.getScreenHeight(activity);
        } else {
            screenWidth = ScreenUtils.getScreenWidth(activity);
        }
        bundle.putInt("height_web_dialog", x.h(activity, (float) (screenWidth * 0.7d)));
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(activity, str, bundle, new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-16777216, 0}));
    }

    public final void a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        b(activity);
    }
}

package com.tencent.qqnt.robot.api.impl;

import android.text.Spanned;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.at.c;
import com.tencent.qqnt.robot.api.IRobotAtApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/robot/api/impl/RobotAtApiImpl;", "Lcom/tencent/qqnt/robot/api/IRobotAtApi;", "", "getAtRobotLimit", "Landroid/text/Spanned;", "spanned", "getAtRobotSpanCount", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAtApiImpl implements IRobotAtApi {
    private static final int AT_ROBOT_DEFAULT_LIMIT = 1;

    @NotNull
    private static final String KEY_AT_ROBOT_LIMIT = "105496";

    @NotNull
    private static final String TAG = "RobotAtApiImpl";

    @Override // com.tencent.qqnt.robot.api.IRobotAtApi
    public int getAtRobotLimit() {
        boolean z16;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(KEY_AT_ROBOT_LIMIT, "1");
        if (loadAsString != null && loadAsString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 1;
        }
        try {
            return new JSONObject(loadAsString).optInt("maxCount", 1);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[getAtRobotLimit] ", e16);
            return 1;
        }
    }

    @Override // com.tencent.qqnt.robot.api.IRobotAtApi
    public int getAtRobotSpanCount(@Nullable Spanned spanned) {
        if (spanned == null) {
            return 0;
        }
        QRouteApi api = QRoute.api(IRobotServiceApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotServiceApi::class.java)");
        IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) api;
        Object[] spans = spanned.getSpans(0, spanned.length(), c.class);
        Intrinsics.checkNotNullExpressionValue(spans, "it.getSpans(0, it.length\u2026opMemberSpan::class.java)");
        int i3 = 0;
        for (Object obj : spans) {
            if (iRobotServiceApi.isRobotUin(((c) obj).k())) {
                i3++;
            }
        }
        return i3;
    }
}

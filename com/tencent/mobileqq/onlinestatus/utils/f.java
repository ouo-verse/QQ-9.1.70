package com.tencent.mobileqq.onlinestatus.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b\u001a2\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000b\u001a\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0000H\u0002\u00a8\u0006\u0015"}, d2 = {"Lmqq/app/AppRuntime$Status;", "originStatus", "", "extStatus", "Lorg/json/JSONObject;", "extInfo", "Lcom/tencent/mobileqq/onlinestatus/model/CustomShareInfo;", "c", "Landroid/os/Bundle;", "bundle", "b", "", "shareType", "", "url", QQWinkConstants.TAB_SUBTITLE, "a", "", "e", "onlineStatus", "d", "qqonlinestatus-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {
    private static final CustomShareInfo a(AppRuntime.Status status, long j3, int i3, String str, String str2) {
        if (i3 == 0 && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        CustomShareInfo customShareInfo = new CustomShareInfo(status, j3);
        customShareInfo.g(i3);
        customShareInfo.k(str);
        customShareInfo.j(str2);
        return customShareInfo;
    }

    @Nullable
    public static final CustomShareInfo b(@NotNull AppRuntime.Status originStatus, long j3, @Nullable Bundle bundle) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(originStatus, "originStatus");
        if (bundle == null) {
            return null;
        }
        int i3 = bundle.getInt("shareType", 0);
        String string = bundle.getString("shareUrl");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        String string2 = bundle.getString("shareWording");
        if (string2 == null) {
            str2 = "";
        } else {
            str2 = string2;
        }
        return a(originStatus, j3, i3, str, str2);
    }

    @Nullable
    public static final CustomShareInfo c(@NotNull AppRuntime.Status originStatus, long j3, @Nullable JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(originStatus, "originStatus");
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("shareType", 0);
        String url = jSONObject.optString("shareUrl");
        String subTitle = jSONObject.optString("shareWording");
        Intrinsics.checkNotNullExpressionValue(url, "url");
        Intrinsics.checkNotNullExpressionValue(subTitle, "subTitle");
        return a(originStatus, j3, optInt, url, subTitle);
    }

    private static final boolean d(AppRuntime.Status status) {
        if (status != AppRuntime.Status.away && status != AppRuntime.Status.dnd && status != AppRuntime.Status.busy) {
            return false;
        }
        return true;
    }

    public static final boolean e(@NotNull AppRuntime.Status originStatus, int i3) {
        Intrinsics.checkNotNullParameter(originStatus, "originStatus");
        if (i3 != 1030 && i3 != 1028 && i3 != 1040 && i3 != 1021 && i3 != 1080 && !d(originStatus)) {
            return false;
        }
        return true;
    }
}

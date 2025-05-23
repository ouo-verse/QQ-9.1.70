package com.tencent.mobileqq.aio.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "", "c", HippyControllerProps.STRING, "", "b", "a", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class as {
    @NotNull
    public static final CharSequence a(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        if (!TextUtils.isEmpty(recentContactInfo.remark)) {
            String str = recentContactInfo.remark;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            remark\n        }");
            return str;
        }
        if (!TextUtils.isEmpty(recentContactInfo.peerName)) {
            String str2 = recentContactInfo.peerName;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n            peerName\n        }");
            return str2;
        }
        return String.valueOf(recentContactInfo.peerUin);
    }

    @NotNull
    public static final String b(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            QRouteApi api = QRoute.api(INickNameApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(INickNameApi::class.java)");
            return INickNameApi.a.a((INickNameApi) api, charSequence, false, 2, null).toString();
        }
        return "";
    }

    @NotNull
    public static final CharSequence c(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        if (aq.f194114a.a()) {
            if (!TextUtils.isEmpty(recentContactInfo.sendRemarkName)) {
                String str = recentContactInfo.sendRemarkName;
                Intrinsics.checkNotNullExpressionValue(str, "{\n                sendRemarkName\n            }");
                return str;
            }
            if (!TextUtils.isEmpty(recentContactInfo.sendMemberName)) {
                String str2 = recentContactInfo.sendMemberName;
                Intrinsics.checkNotNullExpressionValue(str2, "{\n                sendMemberName\n            }");
                return str2;
            }
            if (!TextUtils.isEmpty(recentContactInfo.sendNickName)) {
                String str3 = recentContactInfo.sendNickName;
                Intrinsics.checkNotNullExpressionValue(str3, "{\n                sendNickName\n            }");
                return str3;
            }
            return String.valueOf(recentContactInfo.senderUin);
        }
        if (!TextUtils.isEmpty(recentContactInfo.sendMemberName)) {
            String str4 = recentContactInfo.sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str4, "{\n                sendMemberName\n            }");
            return str4;
        }
        if (!TextUtils.isEmpty(recentContactInfo.sendRemarkName)) {
            String str5 = recentContactInfo.sendRemarkName;
            Intrinsics.checkNotNullExpressionValue(str5, "{\n                sendRemarkName\n            }");
            return str5;
        }
        if (!TextUtils.isEmpty(recentContactInfo.sendNickName)) {
            String str6 = recentContactInfo.sendNickName;
            Intrinsics.checkNotNullExpressionValue(str6, "{\n                sendNickName\n            }");
            return str6;
        }
        return String.valueOf(recentContactInfo.senderUin);
    }
}

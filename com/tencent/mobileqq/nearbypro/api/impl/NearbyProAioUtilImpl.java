package com.tencent.mobileqq.nearbypro.api.impl;

import androidx.annotation.Keep;
import com.tencent.mobileqq.nearbypro.api.INearbyProAioUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/impl/NearbyProAioUtilImpl;", "Lcom/tencent/mobileqq/nearbypro/api/INearbyProAioUtil;", "", "chatType", "", "isMatch", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip;", "tip", "", "sendCommonGary", "checkFavoriteBtnShow", "", "peerId", "", "grayTipContent", "handleGrayTipTacitAnswerInvite", "handleMutualFollow", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProAioUtilImpl implements INearbyProAioUtil {

    @NotNull
    private static final String ENTRY_SWITCH_CONFIG_ID = "102078";

    @NotNull
    private static final String ENTRY_SWITCH_CONFIG_KEY = "isFeatureTurnedOn";

    @NotNull
    private static final String HIGHLIGHT_FLAG = "#highlight{";
    private static final long MUTUAL_FOLLOW = 10446;
    private static final long RELATION_INVITE_FRIEND_FAQ = 10398;

    @NotNull
    private static final String TAG = "NearbyProAioUtilImp";

    private final boolean isMatch(int chatType) {
        if (chatType == 119) {
            return true;
        }
        return false;
    }

    private final void sendCommonGary(LocalGrayTip tip) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QRouteApi api = QRoute.api(INtGrayTipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
        INtGrayTipApi.a.a((INtGrayTipApi) api, peekAppRuntime, tip, null, 4, null);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProAioUtil
    public boolean checkFavoriteBtnShow(int chatType) {
        boolean z16;
        String loadAsString;
        boolean z17;
        try {
            loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(ENTRY_SWITCH_CONFIG_ID, "");
            if (loadAsString.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        } catch (Throwable th5) {
            j.c().d(TAG, "switch error: " + th5);
        }
        if (z17) {
            j.c().c(TAG, "switch: 102078 is empty, default = false");
            z16 = false;
            boolean isMatch = isMatch(chatType);
            j.c().e(TAG, chatType + ", " + isMatch);
            if (!z16 && isMatch) {
                return false;
            }
        }
        z16 = new JSONObject(loadAsString).optBoolean(ENTRY_SWITCH_CONFIG_KEY, false);
        j.c().e(TAG, "switch success: " + z16);
        boolean isMatch2 = isMatch(chatType);
        j.c().e(TAG, chatType + ", " + isMatch2);
        return !z16 ? true : true;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProAioUtil
    public void handleGrayTipTacitAnswerInvite(long peerId, @NotNull String grayTipContent) {
        boolean contains$default;
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder;
        int indexOf$default;
        int indexOf$default2;
        String str;
        String str2;
        CharSequence removeRange;
        Intrinsics.checkNotNullParameter(grayTipContent, "grayTipContent");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder2 = new LocalGrayTip.LocalGrayTipBuilder(String.valueOf(peerId), 119, RELATION_INVITE_FRIEND_FAQ, 1, false, false, null, 112, null);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) grayTipContent, (CharSequence) HIGHLIGHT_FLAG, false, 2, (Object) null);
        if (contains$default) {
            localGrayTipBuilder = localGrayTipBuilder2;
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) grayTipContent, HIGHLIGHT_FLAG, 0, false, 6, (Object) null);
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) grayTipContent, "}", indexOf$default, false, 4, (Object) null);
            if (indexOf$default != -1 && indexOf$default2 != -1 && indexOf$default2 > indexOf$default) {
                str = grayTipContent.substring(indexOf$default + 11, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } else {
                str = "";
            }
            if (indexOf$default != -1 && indexOf$default2 != -1) {
                removeRange = StringsKt__StringsKt.removeRange((CharSequence) grayTipContent, indexOf$default, indexOf$default2 + 1);
                str2 = removeRange.toString();
            } else {
                str2 = grayTipContent;
            }
            localGrayTipBuilder.g(str2, 1);
            localGrayTipBuilder.h(str, new ua2.a(s.a()), 3);
        } else {
            localGrayTipBuilder = localGrayTipBuilder2;
            localGrayTipBuilder.g(grayTipContent, 1);
        }
        QRouteApi api = QRoute.api(INtGrayTipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
        INtGrayTipApi.a.a((INtGrayTipApi) api, peekAppRuntime, localGrayTipBuilder.m(), null, 4, null);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyProAioUtil
    public void handleMutualFollow(long peerId, @NotNull String grayTipContent) {
        Intrinsics.checkNotNullParameter(grayTipContent, "grayTipContent");
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(String.valueOf(peerId), 119, MUTUAL_FOLLOW, 1, false, false, null, 112, null);
        localGrayTipBuilder.g(grayTipContent, 1);
        sendCommonGary(localGrayTipBuilder.m());
    }
}

package com.tencent.sqshow.zootopia.nativeui.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.state.report.SquareReportConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m94.DressControllerInitData;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/q;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "d", "a", "Lcom/tencent/sqshow/zootopia/nativeui/data/i;", "initData", "c", "", "f", "", tl.h.F, "g", "b", "e", "i", "j", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f371046a = new q();

    q() {
    }

    private final boolean a(j channel) {
        ZootopiaSource last = channel.getReporter().getMSource().getLast();
        return last != null && last.getMainSource() == Source.DRAWER && Intrinsics.areEqual(last.getSubSource(), ZootopiaSource.SUB_SOURCE_DRAWER_ZPLAN_MANAGE_PORTAL);
    }

    private final boolean b(j channel) {
        ZootopiaSource last = channel.getReporter().getMSource().getLast();
        if (last != null && last.getMainSource() == Source.StatusSquare) {
            return Intrinsics.areEqual(last.getSubSource(), SquareReportConst.SubSource.SQUARE_CUSTOM_PURCHASE_SOURCE) || Intrinsics.areEqual(last.getSubSource(), SquareReportConst.SubSource.SQUARE_HOST_PURCHASE_SOURCE);
        }
        return false;
    }

    private final boolean d(j channel) {
        ZootopiaSource last = channel.getReporter().getMSource().getLast();
        return last != null && last.getMainSource() == Source.DRAWER && Intrinsics.areEqual(last.getSubSource(), ZootopiaSource.SUB_SOURCE_DRAWER_SUPER_QQ_SHOW_TAB);
    }

    private final String e(j channel) {
        DressControllerInitData mInitData;
        String brandId;
        b94.d avatarDressController = channel.getAvatarDressController();
        return (avatarDressController == null || (mInitData = avatarDressController.getMInitData()) == null || (brandId = mInitData.getBrandId()) == null) ? "" : brandId;
    }

    private final int f(j channel) {
        DressControllerInitData mInitData;
        b94.d avatarDressController = channel.getAvatarDressController();
        if (avatarDressController == null || (mInitData = avatarDressController.getMInitData()) == null) {
            return 0;
        }
        return mInitData.getReqSource();
    }

    private final String g(j channel) {
        JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(channel.getSchemeParams());
        if (b16 == null) {
            return "";
        }
        String optString = b16.optString("JumpToSource", "");
        Intrinsics.checkNotNullExpressionValue(optString, "schemeParams.optString(\"JumpToSource\", \"\")");
        return optString;
    }

    private final String h(j channel) {
        JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(channel.getSchemeParams());
        if (b16 == null) {
            return "";
        }
        String optString = b16.optString("TryOnSource", "");
        Intrinsics.checkNotNullExpressionValue(optString, "schemeParams.optString(\"TryOnSource\", \"\")");
        return optString;
    }

    public final String i(j channel) {
        if (channel == null) {
            return "avatar_mall_list";
        }
        if (f(channel) == 2) {
            String zplanPageOpenSource = channel.getZplanPageOpenSource();
            if (Intrinsics.areEqual(zplanPageOpenSource, "xiaowo_phone") || !Intrinsics.areEqual(zplanPageOpenSource, "xiaowo_same_model")) {
                return "xiaowo_mall_list";
            }
            return "xiaowo_buy_same_style";
        }
        if (e(channel).length() > 0) {
            return "brand_mall_list";
        }
        if (b(channel)) {
            return "square_homepage";
        }
        if (!(h(channel).length() > 0)) {
            return "avatar_mall_list";
        }
        return h(channel);
    }

    public final String j(j channel, AvatarNativeViewInitData initData) {
        g reportParam;
        String zplanPageOpenSource;
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (c(initData)) {
            return (initData == null || (reportParam = initData.getReportParam()) == null || (zplanPageOpenSource = reportParam.getZplanPageOpenSource()) == null) ? "xiaowo_phone" : zplanPageOpenSource;
        }
        if (b(channel)) {
            return "square_homepage";
        }
        if (g(channel).length() > 0) {
            return g(channel);
        }
        if (a(channel)) {
            return "drawer";
        }
        if (d(channel)) {
            return "zplan_drawer";
        }
        return "avatar_character";
    }

    private final boolean c(AvatarNativeViewInitData initData) {
        g reportParam;
        return Intrinsics.areEqual((initData == null || (reportParam = initData.getReportParam()) == null) ? null : reportParam.getZplanAvatarMallPageType(), "2");
    }
}

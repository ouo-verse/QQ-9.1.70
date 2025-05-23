package com.tencent.mobileqq.qwallet.pay;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tencent.im.qqwallet.PaySuccessAd$GetAdRsp;
import tencent.im.qqwallet.PaySuccessAd$QpayAd;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u001a*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t\u001a\"\u0010\u0010\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\t\u00a8\u0006\u0011"}, d2 = {"Ltencent/im/qqwallet/PaySuccessAd$GetAdRsp;", "Lcom/tencent/gdtad/aditem/GdtAd;", "b", "Lcom/tencent/mobileqq/qwallet/pay/FinanceAdInfo;", "a", "", "opName", "ext3", "ext4", "", "opIn", "", "d", "adId", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "actionId", "c", "qwallet-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    @Nullable
    public static final FinanceAdInfo a(@NotNull PaySuccessAd$GetAdRsp paySuccessAd$GetAdRsp) {
        boolean z16;
        Intrinsics.checkNotNullParameter(paySuccessAd$GetAdRsp, "<this>");
        PaySuccessAd$QpayAd paySuccessAd$QpayAd = paySuccessAd$GetAdRsp.qpay_ad.get();
        String id5 = paySuccessAd$QpayAd.f436043id.get();
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        if (id5.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        return new FinanceAdInfo(id5, paySuccessAd$QpayAd.title.get(), paySuccessAd$QpayAd.sub_title.get(), paySuccessAd$QpayAd.banner.get(), paySuccessAd$QpayAd.icon.get(), paySuccessAd$QpayAd.brand.get(), paySuccessAd$QpayAd.button_text.get(), paySuccessAd$QpayAd.button_url.get(), paySuccessAd$QpayAd.trace_info.get(), paySuccessAd$QpayAd.ext_info.get());
    }

    @Nullable
    public static final GdtAd b(@NotNull PaySuccessAd$GetAdRsp paySuccessAd$GetAdRsp) {
        PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list;
        Object firstOrNull;
        PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo> pBRepeatMessageField2;
        List<qq_ad_get.QQAdGetRsp.AdInfo> list2;
        Object firstOrNull2;
        Intrinsics.checkNotNullParameter(paySuccessAd$GetAdRsp, "<this>");
        qq_ad_get.QQAdGetRsp qQAdGetRsp = paySuccessAd$GetAdRsp.qq_ad_get_rsp;
        if (qQAdGetRsp != null && (pBRepeatMessageField = qQAdGetRsp.pos_ads_info) != null && (list = pBRepeatMessageField.get()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo = (qq_ad_get.QQAdGetRsp.PosAdInfo) firstOrNull;
            if (posAdInfo != null && (pBRepeatMessageField2 = posAdInfo.ads_info) != null && (list2 = pBRepeatMessageField2.get()) != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) firstOrNull2;
                if (adInfo != null) {
                    return new GdtAd(adInfo);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static final void c(@Nullable String str, @Nullable String str2, int i3) {
        ml2.c.f416921a.a(i3, str, str2);
    }

    public static final void d(@NotNull String opName, @Nullable String str, @Nullable String str2, int i3) {
        Intrinsics.checkNotNullParameter(opName, "opName");
        com.tencent.mobileqq.qwallet.c.d("", opName, QCircleDaTongConstant.ElementParamValue.WALLET, i3, 0, "", "", str, str2);
    }
}

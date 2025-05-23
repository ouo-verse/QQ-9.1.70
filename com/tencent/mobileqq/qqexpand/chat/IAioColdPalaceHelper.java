package com.tencent.mobileqq.qqexpand.chat;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JD\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&J4\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&J0\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/IAioColdPalaceHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "suc", "", "uinType", "", "uin", "isUsedUp", "Lcom/tencent/mobileqq/qqexpand/chat/d;", "iBanish", "", "doOnReqThrowToColdPalace", "frdUin", "doOnBanishColdPalaceClick", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "doOnColdPalaceLimitConfirm", "doOnColdPalaceLimitCancel", "onBanishColdPalaceGrayTipClick", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IAioColdPalaceHelper extends QRouteApi {
    void doOnBanishColdPalaceClick(@Nullable BaseQQAppInterface app, @Nullable Context context, int uinType, @NotNull String frdUin, @NotNull d iBanish);

    void doOnColdPalaceLimitCancel(@NotNull d iBanish);

    void doOnColdPalaceLimitConfirm(@NotNull BaseQQAppInterface app, @NotNull Activity activity, int uinType, @NotNull String frdUin, @NotNull d iBanish);

    void doOnReqThrowToColdPalace(@Nullable BaseQQAppInterface app, @Nullable Context context, boolean suc, int uinType, @NotNull String uin, boolean isUsedUp, @NotNull d iBanish);

    void onBanishColdPalaceGrayTipClick(@NotNull Context context);
}

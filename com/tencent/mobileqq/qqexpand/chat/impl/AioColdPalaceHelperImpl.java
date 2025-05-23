package com.tencent.mobileqq.qqexpand.chat.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.chat.c;
import com.tencent.mobileqq.qqexpand.chat.d;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019JD\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J4\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J0\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/impl/AioColdPalaceHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/IAioColdPalaceHelper;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "suc", "", "uinType", "", "uin", "isUsedUp", "Lcom/tencent/mobileqq/qqexpand/chat/d;", "iBanish", "", "doOnReqThrowToColdPalace", "frdUin", "doOnBanishColdPalaceClick", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "doOnColdPalaceLimitConfirm", "doOnColdPalaceLimitCancel", "onBanishColdPalaceGrayTipClick", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AioColdPalaceHelperImpl implements IAioColdPalaceHelper {
    @Override // com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper
    public void doOnBanishColdPalaceClick(BaseQQAppInterface app, Context context, int uinType, String frdUin, d iBanish) {
        Intrinsics.checkNotNullParameter(frdUin, "frdUin");
        Intrinsics.checkNotNullParameter(iBanish, "iBanish");
        c.INSTANCE.c(app, context, uinType, frdUin, iBanish);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper
    public void doOnColdPalaceLimitCancel(d iBanish) {
        Intrinsics.checkNotNullParameter(iBanish, "iBanish");
        c.INSTANCE.d(iBanish);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper
    public void doOnColdPalaceLimitConfirm(BaseQQAppInterface app, Activity activity, int uinType, String frdUin, d iBanish) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(frdUin, "frdUin");
        Intrinsics.checkNotNullParameter(iBanish, "iBanish");
        c.INSTANCE.e(app, activity, uinType, frdUin, iBanish);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper
    public void doOnReqThrowToColdPalace(BaseQQAppInterface app, Context context, boolean suc, int uinType, String uin, boolean isUsedUp, d iBanish) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(iBanish, "iBanish");
        c.INSTANCE.f(app, context, suc, uinType, uin, isUsedUp, iBanish);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper
    public void onBanishColdPalaceGrayTipClick(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        c.INSTANCE.k(context);
    }
}

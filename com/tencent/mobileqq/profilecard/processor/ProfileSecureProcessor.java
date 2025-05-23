package com.tencent.mobileqq.profilecard.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/profilecard/processor/ProfileSecureProcessor;", "Lcom/tencent/mobileqq/profilecard/processor/AbsProfileBusinessProcessor;", "appRuntime", "Lmqq/app/AppRuntime;", "(Lmqq/app/AppRuntime;)V", "isContactCardResponse", "", IProfileProtocolConst.PARAM_TARGET_UIN, "", IProfileProtocolConst.PARAM_COME_FROM_TYPE, "", "onResponseProfileCard", "", "success", "params", "Landroid/os/Bundle;", "respHead", "LSummaryCard/RespHead;", "respSummeryCard", "LSummaryCard/RespSummaryCard;", "processProfileCard", "Companion", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ProfileSecureProcessor extends AbsProfileBusinessProcessor {
    private static final String tag = "ProfileSecureProcessor";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSecureProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
    }

    private final boolean isContactCardResponse(long targetUin, int comeFromType) {
        if (targetUin <= 0 && comeFromType != 41 && comeFromType != 6 && comeFromType != 45) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onResponseProfileCard(boolean success, Bundle params, RespHead respHead, RespSummaryCard respSummeryCard) {
        processProfileCard(params, respHead, respSummeryCard);
        boolean z16 = false;
        if (respHead != null && respHead.iResult == 0) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        String valueOf = String.valueOf(respSummeryCard != null ? respSummeryCard.lUIN : 0L);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onResponseProfileCard target[");
        sb5.append(MobileQQ.getShortUinStr(valueOf));
        sb5.append("] result: ");
        sb5.append(respHead != null ? Integer.valueOf(respHead.iResult) : null);
        QLog.i(tag, 1, sb5.toString());
    }

    private final void processProfileCard(Bundle params, RespHead respHead, RespSummaryCard respSummeryCard) {
        String string;
        ContactCard contactCardByMobileNo;
        if (respSummeryCard != null) {
            long j3 = respSummeryCard.lUIN;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            int i3 = params != null ? params.getInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE) : -1;
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
            IProfileDataService iProfileDataService = (IProfileDataService) runtimeService;
            if (isContactCardResponse(j3, i3)) {
                if (params == null || (string = params.getString(IProfileProtocolConst.PARAM_SEARCH_NAME)) == null || (contactCardByMobileNo = iProfileDataService.getContactCardByMobileNo(string, true)) == null || respHead == null) {
                    return;
                }
                int i16 = respHead.iResult;
                contactCardByMobileNo.isForbidAccount = i16 == 201 || i16 == 202;
                contactCardByMobileNo.forbidCode = i16;
                iProfileDataService.saveContactCard(contactCardByMobileNo);
                QLog.i(tag, 1, "onProcessProfileCard,contactCard isForbidAccount=" + contactCardByMobileNo.isForbidAccount);
                return;
            }
            Card profileCard = iProfileDataService.getProfileCard(String.valueOf(j3), true);
            if (profileCard == null) {
                QLog.i(tag, 1, "onProcessProfileCard, get card null");
                return;
            }
            if (respHead != null) {
                int i17 = respHead.iResult;
                profileCard.isForbidAccount = i17 == 201 || i17 == 202;
                profileCard.forbidCode = i17;
                iProfileDataService.saveProfileCard(profileCard);
                QLog.i(tag, 1, "onProcessProfileCard, card isForbidAccount=" + profileCard.isForbidAccount);
            }
        }
    }
}

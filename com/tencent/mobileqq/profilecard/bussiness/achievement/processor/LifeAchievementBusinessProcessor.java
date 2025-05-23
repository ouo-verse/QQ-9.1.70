package com.tencent.mobileqq.profilecard.bussiness.achievement.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.LifeAchivementData;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.ProfileLifeAchievementInfo;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b$ReqBody;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b$RspBody;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class LifeAchievementBusinessProcessor extends AbsProfileBusinessProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final String SUMMARY_CARD_TAG = "Q.profilecard.SummaryCard";
    private static final String TAG = "LifeAchievementBusinessProcessor";

    public LifeAchievementBusinessProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void handleGetLifeAchievementInfo(Card card, SparseArray<BusinessRespBuffer> sparseArray) {
        if (QLog.isColorLevel()) {
            QLog.i(SUMMARY_CARD_TAG, 2, "handleGetLifeAchievementInfo vvRespList=" + sparseArray);
        }
        BusinessRespBuffer businessRespBuffer = sparseArray.get(18);
        if (businessRespBuffer != null && businessRespBuffer.buffer != null) {
            oidb_0xe5b$RspBody oidb_0xe5b_rspbody = new oidb_0xe5b$RspBody();
            try {
                oidb_0xe5b_rspbody.mergeFrom(businessRespBuffer.buffer);
                ProfileLifeAchievementInfo profileLifeAchievementInfo = new ProfileLifeAchievementInfo();
                profileLifeAchievementInfo.lifeAchievementTotalCount = oidb_0xe5b_rspbody.uint32_achievement_totalcount.get();
                profileLifeAchievementInfo.lifeAchievementOpenId = oidb_0xe5b_rspbody.str_achievement_openid.get();
                if (QLog.isColorLevel()) {
                    QLog.i(SUMMARY_CARD_TAG, 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo totalCount=%s openId=%s", Integer.valueOf(profileLifeAchievementInfo.lifeAchievementTotalCount), profileLifeAchievementInfo.lifeAchievementOpenId));
                }
                profileLifeAchievementInfo.lifeAchievementList = new ArrayList<>();
                if (oidb_0xe5b_rspbody.rpt_life_ach_item != null) {
                    for (int i3 = 0; i3 < oidb_0xe5b_rspbody.rpt_life_ach_item.size(); i3++) {
                        LifeAchivementData lifeAchivementData = new LifeAchivementData();
                        lifeAchivementData.f260664id = oidb_0xe5b_rspbody.rpt_life_ach_item.get(i3).uint32_achievement_id.get();
                        lifeAchivementData.title = oidb_0xe5b_rspbody.rpt_life_ach_item.get(i3).str_achievement_title.get();
                        lifeAchivementData.iconUrl = oidb_0xe5b_rspbody.rpt_life_ach_item.get(i3).str_achievement_icon.get();
                        lifeAchivementData.hasPraised = oidb_0xe5b_rspbody.rpt_life_ach_item.get(i3).bool_has_praised.get();
                        lifeAchivementData.praiseNum = oidb_0xe5b_rspbody.rpt_life_ach_item.get(i3).uint32_praise_num.get();
                        if (QLog.isColorLevel()) {
                            QLog.i(SUMMARY_CARD_TAG, 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo id=%s title=%s iconUrl=%s hasPraised=%s praiseNum=%s", Integer.valueOf(lifeAchivementData.f260664id), lifeAchivementData.title, lifeAchivementData.iconUrl, Boolean.valueOf(lifeAchivementData.hasPraised), Integer.valueOf(lifeAchivementData.praiseNum)));
                        }
                        profileLifeAchievementInfo.lifeAchievementList.add(lifeAchivementData);
                    }
                }
                card.putBusinessInfo(profileLifeAchievementInfo);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleGetLifeAchievementInfo onResponse fail." + e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileService(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, SparseArray<BusinessRespBuffer> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bundle, card, respHead, respSummaryCard, sparseArray);
        } else {
            super.onProcessProfileService(bundle, card, respHead, respSummaryCard, sparseArray);
            handleGetLifeAchievementInfo(card, sparseArray);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onRequestProfileCard(Bundle bundle, ArrayList<BusinessReqBuffer> arrayList, ArrayList<Integer> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bundle, arrayList, arrayList2);
            return;
        }
        super.onRequestProfileCard(bundle, arrayList, arrayList2);
        long j3 = bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN, 0L);
        oidb_0xe5b$ReqBody oidb_0xe5b_reqbody = new oidb_0xe5b$ReqBody();
        oidb_0xe5b_reqbody.uint64_uin.set(j3);
        oidb_0xe5b_reqbody.uint32_max_count.set(10);
        oidb_0xe5b_reqbody.bool_req_achievement_content.set(false);
        arrayList.add(new BusinessReqBuffer(18, oidb_0xe5b_reqbody.toByteArray()));
    }
}

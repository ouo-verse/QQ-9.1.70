package com.tencent.mobileqq.profilecard.bussiness.anonymous.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousAnswerInfo;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xec4.oidb_0xec4$Quest;
import tencent.im.oidb.cmd0xec4.oidb_0xec4$ReqBody;
import tencent.im.oidb.cmd0xec4.oidb_0xec4$RspBody;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class AnonymousBusinessProcessor extends AbsProfileBusinessProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AnonymousBusinessProcessor";

    public AnonymousBusinessProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void handleGetAnonymousInfo(Card card, SparseArray<BusinessRespBuffer> sparseArray) {
        int i3;
        boolean z16;
        BusinessRespBuffer businessRespBuffer = sparseArray.get(19);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleGetAnonymousInfo start vvResp = " + businessRespBuffer);
        }
        if (businessRespBuffer != null && businessRespBuffer.buffer != null) {
            try {
                oidb_0xec4$RspBody oidb_0xec4_rspbody = new oidb_0xec4$RspBody();
                oidb_0xec4_rspbody.mergeFrom(businessRespBuffer.buffer);
                ProfileAnonymousAnswerInfo profileAnonymousAnswerInfo = new ProfileAnonymousAnswerInfo();
                profileAnonymousAnswerInfo.mTotalQuestionCount = oidb_0xec4_rspbody.uint32_total_quest_num.get();
                profileAnonymousAnswerInfo.mHasFetchOver = oidb_0xec4_rspbody.bool_is_fetch_over.get();
                if (oidb_0xec4_rspbody.uint32_ret.has()) {
                    i3 = oidb_0xec4_rspbody.uint32_ret.get();
                } else {
                    i3 = -1;
                }
                if (i3 == 10001) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                profileAnonymousAnswerInfo.needForbidEntry = z16;
                profileAnonymousAnswerInfo.mAnsweredQuestionCount = oidb_0xec4_rspbody.uint32_answered_quest_num.get();
                if (oidb_0xec4_rspbody.msg_quest.has()) {
                    long parseLong = Long.parseLong(card.uin);
                    ArrayList arrayList = new ArrayList();
                    Iterator<oidb_0xec4$Quest> it = oidb_0xec4_rspbody.msg_quest.get().iterator();
                    while (it.hasNext()) {
                        AnonymousQuestion convertQuest = AnonymousQuestion.convertQuest(it.next(), parseLong);
                        if (convertQuest != null && !TextUtils.isEmpty(convertQuest.mQuest) && !TextUtils.isEmpty(convertQuest.mAnswer)) {
                            arrayList.add(convertQuest);
                        }
                    }
                    profileAnonymousAnswerInfo.mAnonymousQuestions.addAll(arrayList);
                }
                QLog.d(TAG, 1, String.format("handleGetAnonymousInfo total=%s fetchOver=%s questionSize=%s retCode=%s needForbidEntry=%s answeredCount=%s", Integer.valueOf(profileAnonymousAnswerInfo.mTotalQuestionCount), Boolean.valueOf(profileAnonymousAnswerInfo.mHasFetchOver), Integer.valueOf(profileAnonymousAnswerInfo.mAnonymousQuestions.size()), Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(profileAnonymousAnswerInfo.mAnsweredQuestionCount)));
                card.putBusinessInfo(profileAnonymousAnswerInfo);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "handleGetAnonymousInfo fail.", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onProcessProfileService(Bundle bundle, Card card, RespHead respHead, RespSummaryCard respSummaryCard, SparseArray<BusinessRespBuffer> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bundle, card, respHead, respSummaryCard, sparseArray);
        } else {
            handleGetAnonymousInfo(card, sparseArray);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor, com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
    public void onRequestProfileCard(Bundle bundle, ArrayList<BusinessReqBuffer> arrayList, ArrayList<Integer> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bundle, arrayList, arrayList2);
            return;
        }
        long j3 = bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN, 0L);
        oidb_0xec4$ReqBody oidb_0xec4_reqbody = new oidb_0xec4$ReqBody();
        oidb_0xec4_reqbody.uint64_uin.set(j3);
        oidb_0xec4_reqbody.uint64_quest_num.set(10L);
        oidb_0xec4_reqbody.uint32_fetch_type.set(1);
        arrayList.add(new BusinessReqBuffer(19, oidb_0xec4_reqbody.toByteArray()));
        QLog.d(TAG, 1, "onRequestProfileCard targetUin:" + j3);
    }
}

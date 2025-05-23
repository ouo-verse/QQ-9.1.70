package com.tencent.mobileqq.profilecard.bussiness.anonymous.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xec4.oidb_0xec4$Quest;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AnonymousQuestion {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AnonymousQuestion";
    public String mAnswer;
    public long mAnswerTime;
    public String mId;
    public long mOwnerUin;
    public String mPraiseKey;
    public boolean mPraised;
    public boolean mPrivate;
    public String mQuest;
    public long mQuestTime;
    public long mQuestUin;
    public long mTotalCommentCount;
    public long mTotalPraiseCount;
    public long mTotalViewCount;
    public int uiState;

    public AnonymousQuestion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uiState = 0;
        }
    }

    public static AnonymousQuestion convertQuest(oidb_0xec4$Quest oidb_0xec4_quest, long j3) {
        boolean z16;
        try {
            AnonymousQuestion anonymousQuestion = new AnonymousQuestion();
            anonymousQuestion.mId = oidb_0xec4_quest.str_id.get();
            anonymousQuestion.mQuest = oidb_0xec4_quest.str_quest.get();
            anonymousQuestion.mQuestUin = oidb_0xec4_quest.uint64_quest_uin.get();
            anonymousQuestion.mQuestTime = oidb_0xec4_quest.uint64_time.get();
            anonymousQuestion.mOwnerUin = j3;
            boolean z17 = false;
            if (oidb_0xec4_quest.uint64_show_type.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            anonymousQuestion.mPrivate = z16;
            anonymousQuestion.mAnswer = oidb_0xec4_quest.str_ans.get();
            anonymousQuestion.mAnswerTime = oidb_0xec4_quest.uint64_ans_time.get();
            anonymousQuestion.mPraiseKey = oidb_0xec4_quest.str_like_key.get();
            if (oidb_0xec4_quest.uint64_been_praised.get() == 1) {
                z17 = true;
            }
            anonymousQuestion.mPraised = z17;
            anonymousQuestion.mTotalPraiseCount = oidb_0xec4_quest.uint64_praise_num.get();
            anonymousQuestion.mTotalCommentCount = oidb_0xec4_quest.uint64_comment_num.get();
            anonymousQuestion.mTotalViewCount = oidb_0xec4_quest.uint64_show_times.get();
            return anonymousQuestion;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "convertQuest fail.", e16);
            return null;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "AnonymousQuestion{mId='" + this.mId + "', mQuestUin='" + this.mQuestUin + "', mQuestTime='" + this.mQuestTime + "', mOwnerUin='" + this.mOwnerUin + "', mPrivate='" + this.mPrivate + "', mAnswer='" + this.mAnswer + "', mAnswerTime='" + this.mAnswerTime + "', mPraiseKey='" + this.mPraiseKey + "', mPraised='" + this.mPraised + "', mTotalPraiseCount='" + this.mTotalPraiseCount + "', mTotalCommentCount='" + this.mTotalCommentCount + "', mTotalViewCount='" + this.mTotalViewCount + "'}";
    }
}

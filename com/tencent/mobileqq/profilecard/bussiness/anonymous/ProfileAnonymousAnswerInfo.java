package com.tencent.mobileqq.profilecard.bussiness.anonymous;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class ProfileAnonymousAnswerInfo implements IProfileBusinessInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int REQUEST_FETCH_TYPE = 1;
    public static final int REQUEST_QUESTION_SIZE = 10;
    public List<AnonymousQuestion> mAnonymousQuestions;
    public int mAnsweredQuestionCount;
    public boolean mHasFetchOver;
    public int mTotalQuestionCount;
    public boolean needForbidEntry;

    public ProfileAnonymousAnswerInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTotalQuestionCount = 0;
        this.mAnsweredQuestionCount = 0;
        this.mHasFetchOver = true;
        this.mAnonymousQuestions = new ArrayList();
    }
}

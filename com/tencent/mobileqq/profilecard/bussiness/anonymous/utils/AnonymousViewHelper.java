package com.tencent.mobileqq.profilecard.bussiness.anonymous.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AnonymousViewHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int PARAM_TYPE_FROM_AIO = 4;
    public static final int PARAM_TYPE_FROM_ANSWER = 3;
    public static final int PARAM_TYPE_FROM_CARD = 6;
    public static final int PARAM_TYPE_FROM_CARD_ITEM = 8;
    public static final int PARAM_TYPE_FROM_COMMENT = 7;
    public static final int PARAM_TYPE_FROM_QZONE = 5;
    public static final int PARAM_TYPE_FROM_TITLE = 1;
    public static final int PARAM_TYPE_FROM_TOFU_AIO_MINI_PROFILE_CARD = 9;
    public static final int PARAM_TYPE_FROM_TOFU_ASK_ANONYMOUSLY = 10;
    public static final int PARAM_TYPE_FROM_TOFU_ASK_ANONYMOUSLY_COMMENT = 11;
    public static final int PARAM_TYPE_FROM_TOTAL = 2;
    public static final int RESULT_CODE = 4660;
    public static final String TAG = "AnonymousViewHelper";
    private static final String WEB_URL_ASK_QUES = "https://ti.qq.com/v2/anonymous/question?_wv=16777218&_wwv=129&uin=%s&from=%d";
    private static final String WEB_URL_QUES_DETAIL = "https://ti.qq.com/v2/anonymous/detail?_wv=16777218&_wwv=129&uin=%s&qid=%s&cid=%s&from=%d&qtime=%d";
    private static final String WEB_URL_QUES_LIST_AND_ANSWER = "https://ti.qq.com/v2/anonymous/answer?_wv=16777218&_wwv=129&uin=%s&from=%d";

    public AnonymousViewHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void jumpToAnonymousDetail(Activity activity, String str, String str2, String str3, int i3, long j3) {
        Intent intent = new Intent();
        if (TextUtils.isEmpty(str3)) {
            str3 = "0";
        }
        String format = String.format(WEB_URL_QUES_DETAIL, str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3));
        intent.putExtra("url", format);
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_BROWSER, 4660);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("jumpToAnonymousDetail() uin=%s qId=%s cId=%s form=%d url =%s", str, str2, str3, Integer.valueOf(i3), format));
        }
    }

    public static void jumpToAskQuestion(Activity activity, String str, int i3) {
        Intent intent = new Intent();
        String format = String.format("https://ti.qq.com/v2/anonymous/question?_wv=16777218&_wwv=129&uin=%s&from=%d", str, Integer.valueOf(i3));
        intent.putExtra("url", format);
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_BROWSER, 4660);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("jumpToAskQuestion() uin=%s from=%d url =%s", str, Integer.valueOf(i3), format));
        }
    }

    public static void jumpToComment(Activity activity, String str, String str2, long j3) {
        jumpToAnonymousDetail(activity, str, str2, "", 7, j3);
    }

    public static void jumpToQuestionListAndAnswer(Activity activity, String str, int i3) {
        Intent intent = new Intent();
        String format = String.format(WEB_URL_QUES_LIST_AND_ANSWER, str, Integer.valueOf(i3));
        intent.putExtra("url", format);
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_BROWSER, 4660);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("jumpToQuestionListAndAnswer() uin=%s from=%d url =%s", str, Integer.valueOf(i3), format));
        }
    }

    public static void jumpToReqFriendAskQuestion(Activity activity) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "jumpToReqFriendAskQuestion()");
        }
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).inviteAskAnonymously(activity, true);
    }

    public static void onClickLike(AppInterface appInterface, AnonymousQuestion anonymousQuestion) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "before onClickLike() question.mPraised = " + anonymousQuestion.mPraised);
        }
        ((AnonymousHandler) appInterface.getBusinessHandler(AnonymousHandler.class.getName())).likeAnonymousAnswer(anonymousQuestion, !anonymousQuestion.mPraised);
    }
}

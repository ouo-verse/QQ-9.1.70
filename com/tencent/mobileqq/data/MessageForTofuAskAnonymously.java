package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.constant.AnonymousConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/data/MessageForTofuAskAnonymously;", "Lcom/tencent/mobileqq/data/ChatMessage;", "()V", "askAnonymouslyQuestion", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/bean/AnonymousQuestion;", "getAskAnonymouslyQuestion", "()Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/bean/AnonymousQuestion;", "setAskAnonymouslyQuestion", "(Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/bean/AnonymousQuestion;)V", "doParse", "", "parseJsonToAnonymousQuestion", "jsonStr", "", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class MessageForTofuAskAnonymously extends ChatMessage {

    @NotNull
    public static final String TAG = "MessageForTofuAskAnonymously";

    @Nullable
    private AnonymousQuestion askAnonymouslyQuestion;

    public MessageForTofuAskAnonymously() {
        this.msgtype = -7012;
        this.mNeedTimeStamp = false;
    }

    private final AnonymousQuestion parseJsonToAnonymousQuestion(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonStr);
            AnonymousQuestion anonymousQuestion = new AnonymousQuestion();
            anonymousQuestion.mId = jSONObject.optString(AnonymousConstant.KEY_Q_ID, "");
            anonymousQuestion.mQuest = jSONObject.optString(AnonymousConstant.KEY_Q_STR, "");
            anonymousQuestion.mQuestUin = jSONObject.optLong(AnonymousConstant.KEY_Q_UIN, -1L);
            anonymousQuestion.mQuestTime = jSONObject.optLong(AnonymousConstant.KEY_Q_TIME, -1L);
            anonymousQuestion.mAnswer = jSONObject.optString(AnonymousConstant.KEY_A_STR, "");
            anonymousQuestion.mAnswerTime = jSONObject.optLong(AnonymousConstant.KEY_A_TIME, -1L);
            anonymousQuestion.mPraiseKey = jSONObject.optString(AnonymousConstant.KEY_PRAISE_KEY, "");
            boolean z16 = false;
            if (jSONObject.optInt(AnonymousConstant.KEY_BEEN_PRAISE, 0) == 1) {
                z16 = true;
            }
            anonymousQuestion.mPraised = z16;
            anonymousQuestion.mTotalPraiseCount = jSONObject.optLong(AnonymousConstant.KEY_PRAISE_NUM, -1L);
            anonymousQuestion.mTotalCommentCount = jSONObject.optLong(AnonymousConstant.KEY_COMMENT_NUM, -1L);
            anonymousQuestion.mTotalViewCount = jSONObject.optLong(AnonymousConstant.KEY_SHOW_TIMES, -1L);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "parseJsonToAnonymousQuestion result: " + anonymousQuestion);
            }
            return anonymousQuestion;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseJsonToAnonymousQuestion exception: ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        String msg2 = this.f203106msg;
        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
        this.askAnonymouslyQuestion = parseJsonToAnonymousQuestion(msg2);
        this.isread = true;
    }

    @Nullable
    public final AnonymousQuestion getAskAnonymouslyQuestion() {
        return this.askAnonymouslyQuestion;
    }

    public final void setAskAnonymouslyQuestion(@Nullable AnonymousQuestion anonymousQuestion) {
        this.askAnonymouslyQuestion = anonymousQuestion;
    }
}

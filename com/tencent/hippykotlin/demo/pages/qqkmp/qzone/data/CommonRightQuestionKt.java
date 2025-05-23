package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRightQuestion;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRightQuestion;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRightQuestion;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonRightQuestionKt {
    public static final CommonRightQuestion toCommon(QzoneRightQuestion qzoneRightQuestion) {
        CommonRightQuestion commonRightQuestion = new CommonRightQuestion();
        commonRightQuestion.setQuestion(qzoneRightQuestion.question);
        commonRightQuestion.setAnswer(qzoneRightQuestion.answer);
        return commonRightQuestion;
    }

    public static final QzoneRightQuestion toPb(CommonRightQuestion commonRightQuestion) {
        return new QzoneRightQuestion(commonRightQuestion.getQuestion(), commonRightQuestion.getAnswer());
    }
}

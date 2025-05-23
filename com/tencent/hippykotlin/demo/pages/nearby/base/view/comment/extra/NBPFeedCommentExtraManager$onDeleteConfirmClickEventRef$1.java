package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public /* synthetic */ class NBPFeedCommentExtraManager$onDeleteConfirmClickEventRef$1 extends FunctionReferenceImpl implements Function1<e, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        NBPFeedCommentExtraManager nBPFeedCommentExtraManager = (NBPFeedCommentExtraManager) this.receiver;
        nBPFeedCommentExtraManager.getClass();
        if (eVar2 != null) {
            e m3 = eVar2.m("openData");
            if (m3 == null) {
                m3 = new e();
            }
            String p16 = m3.p("feedId");
            String p17 = m3.p("pager_id");
            NBPFeedCommentDeleteConfirmClickEvent nBPFeedCommentDeleteConfirmClickEvent = new NBPFeedCommentDeleteConfirmClickEvent(new NBPFeedCommentDeleteConfirmOpenEvent(p16, p17, m3.p("targetCommentId"), m3.p("targetReplyId")), eVar2.f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            if (Intrinsics.areEqual(p17, nBPFeedCommentExtraManager.pagerId)) {
                nBPFeedCommentExtraManager.handler.onDeleteConfirmClick(nBPFeedCommentDeleteConfirmClickEvent);
            }
        }
        return Unit.INSTANCE;
    }

    public NBPFeedCommentExtraManager$onDeleteConfirmClickEventRef$1(Object obj) {
        super(1, obj, NBPFeedCommentExtraManager.class, "onDeleteConfirmClickEvent", "onDeleteConfirmClickEvent(Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;)V", 0);
    }
}

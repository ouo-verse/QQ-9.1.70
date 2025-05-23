package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public /* synthetic */ class NBPFeedCommentExtraManager$onDeleteConfirmOpenEventRef$1 extends FunctionReferenceImpl implements Function1<e, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        NBPFeedCommentExtraManager nBPFeedCommentExtraManager = (NBPFeedCommentExtraManager) this.receiver;
        nBPFeedCommentExtraManager.getClass();
        if (eVar2 != null) {
            String p16 = eVar2.p("feedId");
            String p17 = eVar2.p("pager_id");
            NBPFeedCommentDeleteConfirmOpenEvent nBPFeedCommentDeleteConfirmOpenEvent = new NBPFeedCommentDeleteConfirmOpenEvent(p16, p17, eVar2.p("targetCommentId"), eVar2.p("targetReplyId"));
            if (Intrinsics.areEqual(p17, nBPFeedCommentExtraManager.pagerId)) {
                nBPFeedCommentExtraManager.handler.onDeleteConfirmOpen(nBPFeedCommentDeleteConfirmOpenEvent);
            }
        }
        return Unit.INSTANCE;
    }

    public NBPFeedCommentExtraManager$onDeleteConfirmOpenEventRef$1(Object obj) {
        super(1, obj, NBPFeedCommentExtraManager.class, "onDeleteConfirmOpenEvent", "onDeleteConfirmOpenEvent(Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;)V", 0);
    }
}

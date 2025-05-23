package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public /* synthetic */ class NBPFeedCommentExtraManager$onInputClosedEventRef$1 extends FunctionReferenceImpl implements Function1<e, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        NBPFeedCommentExtraManager nBPFeedCommentExtraManager = (NBPFeedCommentExtraManager) this.receiver;
        nBPFeedCommentExtraManager.getClass();
        if (eVar2 != null) {
            NBPFeedCommentInputOpenEvent fromJson = NBPFeedCommentInputOpenEvent.Companion.fromJson(eVar2);
            NBPFeedCommentInputClosedEvent nBPFeedCommentInputClosedEvent = new NBPFeedCommentInputClosedEvent(fromJson, eVar2.f("submit"), eVar2.p("input_text"), eVar2.f("is_quick_comment"));
            if (Intrinsics.areEqual(fromJson.requestId, nBPFeedCommentExtraManager.currentInputOpenRequestId) && Intrinsics.areEqual(fromJson.pagerId, nBPFeedCommentExtraManager.pagerId)) {
                nBPFeedCommentExtraManager.handler.onInputClosed(nBPFeedCommentInputClosedEvent);
            }
        }
        return Unit.INSTANCE;
    }

    public NBPFeedCommentExtraManager$onInputClosedEventRef$1(Object obj) {
        super(1, obj, NBPFeedCommentExtraManager.class, "onInputClosedEvent", "onInputClosedEvent(Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;)V", 0);
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentInputOpenEvent;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public /* synthetic */ class NBPFeedCommentExtraManager$onInputOpenEventRef$1 extends FunctionReferenceImpl implements Function1<e, Unit> {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.currentInputOpenRequestId, r6.requestId) == false) goto L18;
     */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        NBPFeedCommentExtraManager nBPFeedCommentExtraManager = (NBPFeedCommentExtraManager) this.receiver;
        nBPFeedCommentExtraManager.getClass();
        NBPFeedCommentInputOpenEvent.Companion companion = NBPFeedCommentInputOpenEvent.Companion;
        if (eVar2 != null) {
            NBPFeedCommentInputOpenEvent fromJson = companion.fromJson(eVar2);
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onInputOpenEvent reqId cur=");
            m3.append(nBPFeedCommentExtraManager.currentInputOpenRequestId);
            m3.append(" target=");
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, fromJson.requestId, kLog, "NBPFeedCommentExtraManager");
            if (nBPFeedCommentExtraManager.currentInputOpenRequestId.length() == 0) {
                nBPFeedCommentExtraManager.currentInputOpenRequestId = fromJson.requestId;
            }
            if (Intrinsics.areEqual(fromJson.pagerId, nBPFeedCommentExtraManager.pagerId)) {
                nBPFeedCommentExtraManager.handler.onInputOpen(fromJson);
            }
        }
        return Unit.INSTANCE;
    }

    public NBPFeedCommentExtraManager$onInputOpenEventRef$1(Object obj) {
        super(1, obj, NBPFeedCommentExtraManager.class, "onInputOpenEvent", "onInputOpenEvent(Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;)V", 0);
    }
}

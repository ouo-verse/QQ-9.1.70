package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public /* synthetic */ class NBPFeedCommentExtraManager$onMenuClickEventRef$1 extends FunctionReferenceImpl implements Function1<e, Unit> {
    public NBPFeedCommentExtraManager$onMenuClickEventRef$1(Object obj) {
        super(1, obj, NBPFeedCommentExtraManager.class, "onMenuClickEvent", "onMenuClickEvent(Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        NBPFeedCommentMenuItem nBPFeedCommentMenuItem;
        e eVar2 = eVar;
        NBPFeedCommentExtraManager nBPFeedCommentExtraManager = (NBPFeedCommentExtraManager) this.receiver;
        nBPFeedCommentExtraManager.getClass();
        if (eVar2 != null) {
            int j3 = eVar2.j("action");
            NBPFeedCommentMenuItem[] values = NBPFeedCommentMenuItem.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    nBPFeedCommentMenuItem = null;
                    break;
                }
                nBPFeedCommentMenuItem = values[i3];
                if (nBPFeedCommentMenuItem.ordinal() == j3) {
                    break;
                }
                i3++;
            }
            e m3 = eVar2.m("openData");
            if (m3 == null) {
                m3 = new e();
            }
            int j16 = m3.j("appId");
            String p16 = m3.p("feedId");
            String p17 = m3.p("pager_id");
            NBPFeedCommentMenuOpenEvent nBPFeedCommentMenuOpenEvent = new NBPFeedCommentMenuOpenEvent(j16, p16, p17, m3.p("viewerUserId"), m3.p("posterUserId"), m3.p("targetUserId"), m3.p("targetCommentId"), m3.p("targetReplyId"));
            if (nBPFeedCommentMenuItem == null) {
                nBPFeedCommentMenuItem = NBPFeedCommentMenuItem.UNKNOWN;
            }
            NBPFeedCommentMenuClickEvent nBPFeedCommentMenuClickEvent = new NBPFeedCommentMenuClickEvent(nBPFeedCommentMenuOpenEvent, nBPFeedCommentMenuItem);
            if (Intrinsics.areEqual(p17, nBPFeedCommentExtraManager.pagerId)) {
                nBPFeedCommentExtraManager.handler.onMenuClick(nBPFeedCommentMenuClickEvent);
            }
        }
        return Unit.INSTANCE;
    }
}

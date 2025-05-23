package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.hippykotlin.demo.pages.foundation.module.QQBridgeApi;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;

/* loaded from: classes31.dex */
public final class NBPFeedCommentExtraManager {
    public String currentInputOpenRequestId;
    public final INBPFeedCommentExtraHandler handler;
    public final String onDeleteConfirmClickEventRef;
    public final String onDeleteConfirmOpenEventRef;
    public final String onInputClosedEventRef;
    public final String onInputOpenEventRef;
    public final String onInputOpenedEventRef;
    public final String onMenuClickEventRef;
    public final String onMenuOpenEventRef;
    public final String pagerId;

    public NBPFeedCommentExtraManager(String str, INBPFeedCommentExtraHandler iNBPFeedCommentExtraHandler) {
        this.pagerId = str;
        this.handler = iNBPFeedCommentExtraHandler;
        QQBridgeApi qQBridgeApi = QQBridgeApi.INSTANCE;
        this.onInputOpenEventRef = k.b(qQBridgeApi.getNotifyModule(), "NBPFeedCommentInputOpenEvent", false, new NBPFeedCommentExtraManager$onInputOpenEventRef$1(this), 2, null);
        this.onInputOpenedEventRef = k.b(qQBridgeApi.getNotifyModule(), "NBPFeedCommentInputOpenedEvent", false, new NBPFeedCommentExtraManager$onInputOpenedEventRef$1(this), 2, null);
        this.onInputClosedEventRef = k.b(qQBridgeApi.getNotifyModule(), "NBPFeedCommentInputSubmitEvent", false, new NBPFeedCommentExtraManager$onInputClosedEventRef$1(this), 2, null);
        this.onMenuOpenEventRef = k.b(qQBridgeApi.getNotifyModule(), "NBPFeedCommentMenuOpenEvent", false, new NBPFeedCommentExtraManager$onMenuOpenEventRef$1(this), 2, null);
        this.onMenuClickEventRef = k.b(qQBridgeApi.getNotifyModule(), "NBPFeedCommentMenuClickEvent", false, new NBPFeedCommentExtraManager$onMenuClickEventRef$1(this), 2, null);
        this.onDeleteConfirmOpenEventRef = k.b(qQBridgeApi.getNotifyModule(), "NBPFeedCommentDeleteConfirmOpenEvent", false, new NBPFeedCommentExtraManager$onDeleteConfirmOpenEventRef$1(this), 2, null);
        this.onDeleteConfirmClickEventRef = k.b(qQBridgeApi.getNotifyModule(), "NBPFeedCommentDeleteConfirmClickEvent", false, new NBPFeedCommentExtraManager$onDeleteConfirmClickEventRef$1(this), 2, null);
        this.currentInputOpenRequestId = BridgeManager.f117344a.u();
    }

    public final void onDestroy() {
        c cVar = c.f117352a;
        ((k) cVar.g().acquireModule("KRNotifyModule")).e("NBPFeedCommentInputOpenEvent", this.onInputOpenEventRef);
        ((k) cVar.g().acquireModule("KRNotifyModule")).e("NBPFeedCommentInputOpenEvent", this.onInputOpenedEventRef);
        ((k) cVar.g().acquireModule("KRNotifyModule")).e("NBPFeedCommentInputSubmitEvent", this.onInputClosedEventRef);
        ((k) cVar.g().acquireModule("KRNotifyModule")).e("NBPFeedCommentMenuOpenEvent", this.onMenuOpenEventRef);
        ((k) cVar.g().acquireModule("KRNotifyModule")).e("NBPFeedCommentMenuClickEvent", this.onMenuClickEventRef);
        ((k) cVar.g().acquireModule("KRNotifyModule")).e("NBPFeedCommentDeleteConfirmOpenEvent", this.onDeleteConfirmOpenEventRef);
        ((k) cVar.g().acquireModule("KRNotifyModule")).e("NBPFeedCommentDeleteConfirmClickEvent", this.onDeleteConfirmClickEventRef);
    }
}

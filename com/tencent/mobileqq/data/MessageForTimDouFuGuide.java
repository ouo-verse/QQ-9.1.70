package com.tencent.mobileqq.data;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForTimDouFuGuide extends ChatMessage {
    public AppGuideTipsConfig config;

    public MessageForTimDouFuGuide(AppGuideTipsConfig appGuideTipsConfig) {
        this.msgtype = MessageRecord.MSG_TYPE_TIM_DOUFU_GUIDE;
        this.config = appGuideTipsConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
    }
}

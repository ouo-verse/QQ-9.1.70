package com.tencent.mobileqq.app.richtext;

import java.util.List;

/* loaded from: classes11.dex */
public interface RichTextAndMsgViaProviderGenerator extends com.tencent.imcore.message.basic.a<IRichTextAndMsgViaProvider> {
    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ List<IRichTextAndMsgViaProvider> getInstances();

    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ void register(Class<? extends IRichTextAndMsgViaProvider> cls);

    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ void unregister(Class<? extends IRichTextAndMsgViaProvider> cls);

    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ List<Class<? extends IRichTextAndMsgViaProvider>> values();
}

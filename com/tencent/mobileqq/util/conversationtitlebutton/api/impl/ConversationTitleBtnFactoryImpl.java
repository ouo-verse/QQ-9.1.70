package com.tencent.mobileqq.util.conversationtitlebutton.api.impl;

import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnConfig;
import com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonProcessorManager;
import com.tencent.mobileqq.util.conversationtitlebutton.api.IConversationTitleBtnFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnFactoryImpl;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/api/IConversationTitleBtnFactory;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/c;", "conversation", "Lcom/tencent/mobileqq/util/conversationtitlebutton/d;", "createConversationTitleBtn", "Lcom/tencent/mobileqq/tianshu/data/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "createTitleButtonDynamicRedPoint", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "", "callback", "createConversationTitleBtnConfig", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ConversationTitleBtnFactoryImpl implements IConversationTitleBtnFactory {
    @Override // com.tencent.mobileqq.util.conversationtitlebutton.api.IConversationTitleBtnFactory
    public com.tencent.mobileqq.util.conversationtitlebutton.d createConversationTitleBtn(com.tencent.mobileqq.util.conversationtitlebutton.c conversation) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        return new ConversationTitleBtnHelperApiImpl(conversation);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.api.IConversationTitleBtnFactory
    public void createConversationTitleBtnConfig(Function1<? super ConversationTitleBtnConfig, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TitleButtonProcessorManager.INSTANCE.a().i(false, callback);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.api.IConversationTitleBtnFactory
    public BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface createTitleButtonDynamicRedPoint() {
        return new com.tencent.mobileqq.util.conversationtitlebutton.f();
    }
}

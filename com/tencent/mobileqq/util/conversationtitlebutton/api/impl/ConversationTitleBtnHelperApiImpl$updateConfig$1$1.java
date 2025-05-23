package com.tencent.mobileqq.util.conversationtitlebutton.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "it", "", "invoke", "(Lcom/tencent/mobileqq/util/conversationtitlebutton/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ConversationTitleBtnHelperApiImpl$updateConfig$1$1 extends Lambda implements Function1<ConversationTitleBtnConfig, Unit> {
    final /* synthetic */ long $startTime;
    final /* synthetic */ WeakReference<ConversationTitleBtnHelperApiImpl> $weakSelf;
    final /* synthetic */ ConversationTitleBtnHelperApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationTitleBtnHelperApiImpl$updateConfig$1$1(long j3, ConversationTitleBtnHelperApiImpl conversationTitleBtnHelperApiImpl, WeakReference<ConversationTitleBtnHelperApiImpl> weakReference) {
        super(1);
        this.$startTime = j3;
        this.this$0 = conversationTitleBtnHelperApiImpl;
        this.$weakSelf = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WeakReference weakSelf, ConversationTitleBtnConfig it) {
        Intrinsics.checkNotNullParameter(weakSelf, "$weakSelf");
        Intrinsics.checkNotNullParameter(it, "$it");
        ConversationTitleBtnHelperApiImpl conversationTitleBtnHelperApiImpl = (ConversationTitleBtnHelperApiImpl) weakSelf.get();
        if (conversationTitleBtnHelperApiImpl != null) {
            conversationTitleBtnHelperApiImpl.J(it);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConversationTitleBtnConfig conversationTitleBtnConfig) {
        invoke2(conversationTitleBtnConfig);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final ConversationTitleBtnConfig it) {
        Intrinsics.checkNotNullParameter(it, "it");
        QLog.i("ConversationTitleBtnHelper", 1, "[getConfig] init config, time=" + (System.currentTimeMillis() - this.$startTime) + " uin=" + this.this$0.E() + " id=" + it.getBusinessId() + " config=" + it);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final WeakReference<ConversationTitleBtnHelperApiImpl> weakReference = this.$weakSelf;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                ConversationTitleBtnHelperApiImpl$updateConfig$1$1.b(weakReference, it);
            }
        });
    }
}

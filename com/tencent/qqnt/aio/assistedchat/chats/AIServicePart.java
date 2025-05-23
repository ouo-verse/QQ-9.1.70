package com.tencent.qqnt.aio.assistedchat.chats;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.aio.assistedchat.chats.AIServicePart$kuiklyEventReceiver$2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import tl.h;

@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u000b*\u0001\u0017\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/chats/AIServicePart;", "Lcom/tencent/qqnt/chats/biz/main/part/a;", "Landroid/content/Intent;", "intent", "", "ba", "ea", "Lkotlin/Function0;", "block", "ca", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "J9", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "com/tencent/qqnt/aio/assistedchat/chats/AIServicePart$kuiklyEventReceiver$2$1", "f", "Lkotlin/Lazy;", "aa", "()Lcom/tencent/qqnt/aio/assistedchat/chats/AIServicePart$kuiklyEventReceiver$2$1;", "kuiklyEventReceiver", "<init>", "()V", h.F, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIServicePart extends com.tencent.qqnt.chats.biz.main.part.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy kuiklyEventReceiver;

    public AIServicePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AIServicePart$kuiklyEventReceiver$2.AnonymousClass1>() { // from class: com.tencent.qqnt.aio.assistedchat.chats.AIServicePart$kuiklyEventReceiver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.qqnt.aio.assistedchat.chats.AIServicePart$kuiklyEventReceiver$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final AIServicePart aIServicePart = AIServicePart.this;
                return new BroadcastReceiver() { // from class: com.tencent.qqnt.aio.assistedchat.chats.AIServicePart$kuiklyEventReceiver$2.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        if (intent != null) {
                            AIServicePart.this.ba(intent);
                        }
                    }
                };
            }
        });
        this.kuiklyEventReceiver = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIServicePart$kuiklyEventReceiver$2.AnonymousClass1 aa() {
        return (AIServicePart$kuiklyEventReceiver$2.AnonymousClass1) this.kuiklyEventReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(Intent intent) {
        if (Intrinsics.areEqual(l.a(intent), "NBPEnterEvent")) {
            ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).activateAIServiceExp(119);
        }
    }

    private final void ca(final Function0<Unit> block) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.chats.a
            @Override // java.lang.Runnable
            public final void run() {
                AIServicePart.da(Function0.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        try {
            block.invoke();
        } catch (Exception e16) {
            QLog.e("AIServicePart", 1, "safeRunOnSubThread: ", e16);
        }
    }

    private final void ea() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "AIServicePart", null, null, null, new AIServicePart$tryToShowAIServiceDialog$1(this, null), 14, null);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void J9() {
        ea();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime newRuntime) {
        ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).tryToDismissAIServiceDialog();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onLogout(Constants.LogoutReason reason) {
        ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).tryToDismissAIServiceDialog();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(final Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        ca(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.chats.AIServicePart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AIServicePart$kuiklyEventReceiver$2.AnonymousClass1 aa5;
                Activity activity2 = activity;
                if (activity2 != null) {
                    aa5 = this.aa();
                    l.c(activity2, aa5);
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(final Activity activity) {
        super.onPartDestroy(activity);
        ca(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.chats.AIServicePart$onPartDestroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AIServicePart$kuiklyEventReceiver$2.AnonymousClass1 aa5;
                Activity activity2 = activity;
                if (activity2 != null) {
                    aa5 = this.aa();
                    l.f(activity2, aa5);
                }
            }
        });
    }
}

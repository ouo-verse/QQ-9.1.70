package com.tencent.mobileqq.matchfriend.reborn.register.guest;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/guest/QQStrangerGuestCheckPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/os/Handler$Callback;", "", "z9", "A9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "Landroid/os/Message;", "msg", "", "handleMessage", "Landroid/os/Handler;", "d", "Lkotlin/Lazy;", "x9", "()Landroid/os/Handler;", "uiHandler", "<init>", "()V", "e", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerGuestCheckPart extends Part implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy uiHandler;

    public QQStrangerGuestCheckPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestCheckPart$uiHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper(), QQStrangerGuestCheckPart.this);
            }
        });
        this.uiHandler = lazy;
    }

    private final void A9() {
        x9().removeMessages(1);
    }

    private final Handler x9() {
        return (Handler) this.uiHandler.getValue();
    }

    private final void z9() {
        if (QQStrangerGuestHelper.f245363a.c()) {
            return;
        }
        A9();
        x9().sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Activity activity;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1 && (activity = getActivity()) != null) {
            QLog.d("QQStrangerGuestCheckPart", 1, "wait 30000, jump register");
            QQStrangerGuestHelper.f245363a.b(activity);
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        A9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        z9();
    }
}

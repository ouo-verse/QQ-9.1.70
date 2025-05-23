package com.tencent.mobileqq.zplan.manager;

import android.os.Handler;
import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler$Callback;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanProfileLikeManager$subCallback$2 extends Lambda implements Function0<Handler.Callback> {
    final /* synthetic */ ZPlanProfileLikeManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanProfileLikeManager$subCallback$2(ZPlanProfileLikeManager zPlanProfileLikeManager) {
        super(0);
        this.this$0 = zPlanProfileLikeManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(ZPlanProfileLikeManager this$0, Message message) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "message");
        int i16 = message.what;
        i3 = this$0.SUB_THREAD_MSG_REQ_FAVORITE;
        if (i16 != i3) {
            return true;
        }
        this$0.q();
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Handler.Callback invoke() {
        final ZPlanProfileLikeManager zPlanProfileLikeManager = this.this$0;
        return new Handler.Callback() { // from class: com.tencent.mobileqq.zplan.manager.c
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean b16;
                b16 = ZPlanProfileLikeManager$subCallback$2.b(ZPlanProfileLikeManager.this, message);
                return b16;
            }
        };
    }
}

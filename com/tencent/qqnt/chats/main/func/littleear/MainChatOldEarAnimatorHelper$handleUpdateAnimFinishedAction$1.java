package com.tencent.qqnt.chats.main.func.littleear;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class MainChatOldEarAnimatorHelper$handleUpdateAnimFinishedAction$1 extends Lambda implements Function0<Boolean> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $delay;
    final /* synthetic */ MainChatOldEarAnimatorHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainChatOldEarAnimatorHelper$handleUpdateAnimFinishedAction$1(MainChatOldEarAnimatorHelper mainChatOldEarAnimatorHelper, long j3) {
        super(0);
        this.this$0 = mainChatOldEarAnimatorHelper;
        this.$delay = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mainChatOldEarAnimatorHelper, Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Boolean invoke() {
        Handler handler;
        final Function0 function0;
        Handler handler2;
        final Function0 function02;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        handler = this.this$0.mUiHandler;
        function0 = this.this$0.mUpdateRunnable;
        handler.removeCallbacks(new Runnable() { // from class: com.tencent.qqnt.chats.main.func.littleear.g
            @Override // java.lang.Runnable
            public final void run() {
                MainChatOldEarAnimatorHelper$handleUpdateAnimFinishedAction$1.c(Function0.this);
            }
        });
        handler2 = this.this$0.mUiHandler;
        function02 = this.this$0.mUpdateRunnable;
        return Boolean.valueOf(handler2.postDelayed(new Runnable() { // from class: com.tencent.qqnt.chats.main.func.littleear.h
            @Override // java.lang.Runnable
            public final void run() {
                MainChatOldEarAnimatorHelper$handleUpdateAnimFinishedAction$1.d(Function0.this);
            }
        }, this.$delay));
    }
}

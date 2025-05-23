package com.tencent.mobileqq.troop.homework.notice;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "nickInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class HWNoticeUtils$getNickName$1 extends Lambda implements Function1<TroopMemberNickInfo, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ String $memberUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HWNoticeUtils$getNickName$1(String str, Function1<? super String, Unit> function1) {
        super(1);
        this.$memberUin = str;
        this.$callback = function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 callback, String name) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(name, "$name");
        callback.invoke(name);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
        invoke2(troopMemberNickInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
        final String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
            return;
        }
        if (troopMemberNickInfo == null || (str = troopMemberNickInfo.getShowName()) == null) {
            str = this.$memberUin;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Function1<String, Unit> function1 = this.$callback;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.a
            @Override // java.lang.Runnable
            public final void run() {
                HWNoticeUtils$getNickName$1.b(Function1.this, str);
            }
        });
    }
}

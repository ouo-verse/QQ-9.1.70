package com.tencent.qqnt.aio.bottombar.sectionbar.processor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.d;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class LiteActionProcessor$doLiteAction$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ LiteActionProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiteActionProcessor$doLiteAction$1(LiteActionProcessor liteActionProcessor) {
        super(0);
        this.this$0 = liteActionProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) liteActionProcessor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, String str) {
        QLog.d("LiteActionProcessor", 1, "getLiteBusiness result: " + i3 + ", errMsg: " + str);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        HashSet<LiteBusinessType> hashSet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String j3 = this.this$0.d().g().r().c().j();
        d dVar = d.f353112a;
        hashSet = this.this$0.bizTypeSet;
        dVar.f(j3, hashSet, new IOperateCallback() { // from class: com.tencent.qqnt.aio.bottombar.sectionbar.processor.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                LiteActionProcessor$doLiteAction$1.c(i3, str);
            }
        });
    }
}

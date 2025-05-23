package com.tencent.mvi.base.route;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes21.dex */
final class VMMessenger2$send$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MsgIntent $message;
    final /* synthetic */ String $msgType;
    final /* synthetic */ l this$0;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.mvi.base.route.VMMessenger2$send$1$2, reason: invalid class name */
    /* loaded from: classes21.dex */
    static final class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap f337761d;
        final /* synthetic */ VMMessenger2$send$1 this$0;

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            for (Map.Entry entry : this.f337761d.entrySet()) {
                this.this$0.getClass();
                VMMessenger2$send$1 vMMessenger2$send$1 = this.this$0;
                l.o(null, entry, vMMessenger2$send$1.$message, vMMessenger2$send$1.$msgType);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VMMessenger2$send$1(l lVar, String str, MsgIntent msgIntent) {
        super(0);
        this.$msgType = str;
        this.$message = msgIntent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, lVar, str, msgIntent);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        l.p(null, true);
        if (this.$message.isSticky() && this.$msgType != null) {
            l.n(null).put(this.$msgType, this.$message);
        }
        if (!l.m(null).containsKey(this.$msgType)) {
            l.p(null, false);
        } else {
            if (((ConcurrentHashMap) l.m(null).get(this.$msgType)) == null) {
                l.p(null, false);
                return;
            }
            throw null;
        }
    }
}

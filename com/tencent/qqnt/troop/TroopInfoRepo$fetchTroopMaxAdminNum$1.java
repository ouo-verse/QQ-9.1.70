package com.tencent.qqnt.troop;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberMaxNumRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberMaxNumCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0005H\n\u00a2\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "groupCode", "", "onRsp", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberMaxNumRsp;", "result", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TroopInfoRepo$fetchTroopMaxAdminNum$1 extends Lambda implements Function2<Long, Function3<? super Integer, ? super String, ? super GroupMemberMaxNumRsp, ? extends Unit>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $isTroopMember;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopInfoRepo$fetchTroopMaxAdminNum$1(boolean z16) {
        super(2);
        this.$isTroopMember = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function3 tmp0, int i3, String str, GroupMemberMaxNumRsp groupMemberMaxNumRsp) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str, groupMemberMaxNumRsp);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l3, Function3<? super Integer, ? super String, ? super GroupMemberMaxNumRsp, ? extends Unit> function3) {
        invoke(l3.longValue(), (Function3<? super Integer, ? super String, ? super GroupMemberMaxNumRsp, Unit>) function3);
        return Unit.INSTANCE;
    }

    public final void invoke(long j3, @NotNull final Function3<? super Integer, ? super String, ? super GroupMemberMaxNumRsp, Unit> onRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), onRsp);
            return;
        }
        Intrinsics.checkNotNullParameter(onRsp, "onRsp");
        int i3 = this.$isTroopMember ? 0 : 111;
        com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
        if (b16 != null) {
            b16.getGroupMemberMaxNum(j3, i3, new IGroupMemberMaxNumCallback() { // from class: com.tencent.qqnt.troop.av
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberMaxNumCallback
                public final void onResult(int i16, String str, GroupMemberMaxNumRsp groupMemberMaxNumRsp) {
                    TroopInfoRepo$fetchTroopMaxAdminNum$1.b(Function3.this, i16, str, groupMemberMaxNumRsp);
                }
            });
        }
    }
}

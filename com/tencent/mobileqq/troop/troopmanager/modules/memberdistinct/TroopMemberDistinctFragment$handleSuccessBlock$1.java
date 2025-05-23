package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct;

import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "rspData", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopMemberDistinctFragment$handleSuccessBlock$1 extends Lambda implements Function1<byte[], Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopMemberDistinctFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberDistinctFragment$handleSuccessBlock$1(TroopMemberDistinctFragment troopMemberDistinctFragment) {
        super(1);
        this.this$0 = troopMemberDistinctFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopMemberDistinctFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopMemberDistinctFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qh();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
        invoke2(bArr);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable byte[] bArr) {
        String str;
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            return;
        }
        Intent intent = new Intent();
        str = this.this$0.troopUin;
        intent.putExtra("troop_uin", str);
        intent.putExtra("key_distinct_member_pb_data", bArr);
        arrayList = this.this$0.chooseArray;
        intent.putStringArrayListExtra("choose_troop_code", arrayList);
        QPublicFragmentActivity.startForResult(this.this$0, intent, (Class<? extends QPublicBaseFragment>) TroopMemberDistinctResultFragment.class, 1001);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final TroopMemberDistinctFragment troopMemberDistinctFragment = this.this$0;
        uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberDistinctFragment$handleSuccessBlock$1.b(TroopMemberDistinctFragment.this);
            }
        }, 500L);
    }
}

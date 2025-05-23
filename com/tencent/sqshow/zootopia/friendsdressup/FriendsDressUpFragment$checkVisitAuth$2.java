package com.tencent.sqshow.zootopia.friendsdressup;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/data/h;", "data", "", "invoke", "(Lcom/tencent/mobileqq/vas/data/h;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FriendsDressUpFragment$checkVisitAuth$2 extends Lambda implements Function1<com.tencent.mobileqq.vas.data.h, Unit> {
    final /* synthetic */ FriendsDressUpFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsDressUpFragment$checkVisitAuth$2(FriendsDressUpFragment friendsDressUpFragment) {
        super(1);
        this.this$0 = friendsDressUpFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FriendsDressUpFragment this$0, com.tencent.mobileqq.vas.data.h hVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isOpenedSmallHome = hVar != null ? hVar.getIsCanVisit() : false;
        this$0.hj();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.vas.data.h hVar) {
        invoke2(hVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final com.tencent.mobileqq.vas.data.h hVar) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            final FriendsDressUpFragment friendsDressUpFragment = this.this$0;
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.o
                @Override // java.lang.Runnable
                public final void run() {
                    FriendsDressUpFragment$checkVisitAuth$2.b(FriendsDressUpFragment.this, hVar);
                }
            });
        }
    }
}

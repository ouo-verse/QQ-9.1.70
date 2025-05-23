package com.tencent.mobileqq.troop.troopnotification.recommend;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopNotificationWithRecommendFragment$initObserver$1$1 extends Lambda implements Function1<List<? extends Object>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopNotificationWithRecommendFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopNotificationWithRecommendFragment$initObserver$1$1(TroopNotificationWithRecommendFragment troopNotificationWithRecommendFragment) {
        super(1);
        this.this$0 = troopNotificationWithRecommendFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopNotificationWithRecommendFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        if (QLog.isDebugVersion()) {
            QLog.d("TroopNotifyWithRcmdFrag", 4, "[initObserver] setItems finish");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TroopNotificationWithRecommendFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        recyclerView = this$0.recyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable List<? extends Object> list) {
        boolean Qh;
        h hVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        Qh = this.this$0.Qh();
        if (QLog.isDebugVersion()) {
            QLog.i("TroopNotifyWithRcmdFrag", 4, "[initObserver] size:" + (list != null ? Integer.valueOf(list.size()) : null) + ", isFirstItemShow:" + Qh);
        }
        hVar = this.this$0.adapter;
        if (hVar != null) {
            hVar.setItems(list, new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.o
                @Override // java.lang.Runnable
                public final void run() {
                    TroopNotificationWithRecommendFragment$initObserver$1$1.c();
                }
            });
        }
        if (Qh) {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final TroopNotificationWithRecommendFragment troopNotificationWithRecommendFragment = this.this$0;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.p
                @Override // java.lang.Runnable
                public final void run() {
                    TroopNotificationWithRecommendFragment$initObserver$1$1.d(TroopNotificationWithRecommendFragment.this);
                }
            });
        }
    }
}

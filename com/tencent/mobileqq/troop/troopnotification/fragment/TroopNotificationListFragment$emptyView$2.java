package com.tencent.mobileqq.troop.troopnotification.fragment;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
final class TroopNotificationListFragment$emptyView$2 extends Lambda implements Function0<QUIEmptyState> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopNotificationListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopNotificationListFragment$emptyView$2(TroopNotificationListFragment troopNotificationListFragment) {
        super(0);
        this.this$0 = troopNotificationListFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopNotificationListFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUIEmptyState invoke() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUIEmptyState) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(this.this$0.getContext()).setImageType(12);
        String string = this.this$0.requireActivity().getResources().getString(R.string.f235157aw);
        Intrinsics.checkNotNullExpressionValue(string, "requireActivity().resour\u2026troop_notification_empty)");
        QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(1).build();
        build.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopNotificationListFragment$emptyView$2.b(view);
            }
        });
        viewGroup = this.this$0.contentView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            viewGroup = null;
        }
        viewGroup.addView(build, -1, -1);
        return build;
    }
}

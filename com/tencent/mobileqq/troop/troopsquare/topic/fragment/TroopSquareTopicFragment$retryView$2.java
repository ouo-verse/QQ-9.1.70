package com.tencent.mobileqq.troop.troopsquare.topic.fragment;

import android.view.View;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
final class TroopSquareTopicFragment$retryView$2 extends Lambda implements Function0<QUIEmptyState> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopSquareTopicFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSquareTopicFragment$retryView$2(TroopSquareTopicFragment troopSquareTopicFragment) {
        super(0);
        this.this$0 = troopSquareTopicFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSquareTopicFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TroopSquareTopicFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.troop.trooptodo.a.a("retryView") && NetworkUtil.isNetworkAvailable()) {
            this$0.Gh(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUIEmptyState invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUIEmptyState) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QUIEmptyState.Builder title = new QUIEmptyState.Builder(this.this$0.getContext()).setImageType(5).setBackgroundColorType(2).setTitle("\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
        final TroopSquareTopicFragment troopSquareTopicFragment = this.this$0;
        QUIEmptyState build = title.setButton("\u91cd\u8bd5", new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSquareTopicFragment$retryView$2.c(TroopSquareTopicFragment.this, view);
            }
        }).build();
        build.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSquareTopicFragment$retryView$2.d(view);
            }
        });
        return build;
    }
}

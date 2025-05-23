package com.tencent.mobileqq.troop.homework.clockin.template;

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
final class HWClockInTemplateFragment$retryView$2 extends Lambda implements Function0<QUIEmptyState> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ HWClockInTemplateFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInTemplateFragment$retryView$2(HWClockInTemplateFragment hWClockInTemplateFragment) {
        super(0);
        this.this$0 = hWClockInTemplateFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWClockInTemplateFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(HWClockInTemplateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (NetworkUtil.isNetworkAvailable()) {
            this$0.initData();
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
        QUIEmptyState.Builder title = new QUIEmptyState.Builder(this.this$0.getContext()).setImageType(5).setBackgroundColorType(2).setTitle("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
        final HWClockInTemplateFragment hWClockInTemplateFragment = this.this$0;
        QUIEmptyState build = title.setButton("\u91cd\u8bd5", new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.template.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWClockInTemplateFragment$retryView$2.c(HWClockInTemplateFragment.this, view);
            }
        }).build();
        build.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.template.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWClockInTemplateFragment$retryView$2.d(view);
            }
        });
        return build;
    }
}

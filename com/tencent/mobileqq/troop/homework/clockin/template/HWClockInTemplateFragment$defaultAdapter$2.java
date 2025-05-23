package com.tencent.mobileqq.troop.homework.clockin.template;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.publish.HWClockInPublishFragment;
import com.tencent.mobileqq.troop.homework.clockin.template.vm.HWClockInTemplateViewModel;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
final class HWClockInTemplateFragment$defaultAdapter$2 extends Lambda implements Function0<QUIListItemAdapter> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ HWClockInTemplateFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInTemplateFragment$defaultAdapter$2(HWClockInTemplateFragment hWClockInTemplateFragment) {
        super(0);
        this.this$0 = hWClockInTemplateFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWClockInTemplateFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HWClockInTemplateFragment this$0, View it) {
        HashMap hashMapOf;
        HWClockInTemplateViewModel yh5;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.homework.clockin.report.a aVar = com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("template_num", 0));
        h.a.f(aVar, it, "em_group_clock_in_template", hashMapOf, null, 8, null);
        HWClockInPublishFragment.Companion companion = HWClockInPublishFragment.INSTANCE;
        yh5 = this$0.yh();
        HWClockInPublishFragment.Companion.b(companion, yh5.P1(), null, null, null, 14, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUIListItemAdapter invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        x xVar = new x(new x.b.C8996b("\u81ea\u5b9a\u4e49\u6253\u5361", R.drawable.qui_edit), new x.c.g("", false, false, 6, null));
        final HWClockInTemplateFragment hWClockInTemplateFragment = this.this$0;
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.template.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWClockInTemplateFragment$defaultAdapter$2.b(HWClockInTemplateFragment.this, view);
            }
        });
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        qUIListItemAdapter.t0(new Group(xVar));
        return qUIListItemAdapter;
    }
}

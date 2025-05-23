package com.tencent.mobileqq.troop.teamup.publish.part;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.publish.fragment.TroopTeamUpPublishFragment;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "invoke", "()Lcom/tencent/mobileqq/widget/listitem/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpTemplatesGalleryPart$customPublishConfig$2 extends Lambda implements Function0<x<x.b.C8996b, x.c.g>> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopTeamUpTemplatesGalleryPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpTemplatesGalleryPart$customPublishConfig$2(TroopTeamUpTemplatesGalleryPart troopTeamUpTemplatesGalleryPart) {
        super(0);
        this.this$0 = troopTeamUpTemplatesGalleryPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopTeamUpTemplatesGalleryPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopTeamUpTemplatesGalleryPart this$0, View view) {
        com.tencent.mobileqq.troop.teamup.publish.vm.d G9;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopTeamUpPublishFragment.Companion companion = TroopTeamUpPublishFragment.INSTANCE;
        G9 = this$0.G9();
        companion.a(G9.N1(), null, this$0.getActivity(), 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final x<x.b.C8996b, x.c.g> invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (x) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String string = this.this$0.getContext().getString(R.string.f236347e4);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026p_team_up_publish_custom)");
        x<x.b.C8996b, x.c.g> xVar = new x<>(new x.b.C8996b(string, R.drawable.qui_edit_plus), new x.c.g("", false, false, 6, null));
        final TroopTeamUpTemplatesGalleryPart troopTeamUpTemplatesGalleryPart = this.this$0;
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpTemplatesGalleryPart$customPublishConfig$2.b(TroopTeamUpTemplatesGalleryPart.this, view);
            }
        });
        return xVar;
    }
}

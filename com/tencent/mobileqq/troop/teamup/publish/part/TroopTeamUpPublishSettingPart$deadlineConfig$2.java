package com.tencent.mobileqq.troop.teamup.publish.part;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "invoke", "()Lcom/tencent/mobileqq/widget/listitem/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpPublishSettingPart$deadlineConfig$2 extends Lambda implements Function0<x<x.b.d, x.c.g>> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopTeamUpPublishSettingPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpPublishSettingPart$deadlineConfig$2(TroopTeamUpPublishSettingPart troopTeamUpPublishSettingPart) {
        super(0);
        this.this$0 = troopTeamUpPublishSettingPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopTeamUpPublishSettingPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String title, TroopTeamUpPublishSettingPart this$0, View view) {
        TroopTeamUpPublishVM D9;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        D9 = this$0.D9();
        MutableLiveData<Calendar> M1 = D9.M1();
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026OND, 0)\n                }");
        com.tencent.mobileqq.troop.teamup.publish.c.k(context, title, M1, calendar);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final x<x.b.d, x.c.g> invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (x) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final String string = this.this$0.getContext().getString(R.string.f236357e5);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026team_up_publish_deadline)");
        x<x.b.d, x.c.g> b16 = x.Companion.b(x.INSTANCE, string, null, 2, null);
        final TroopTeamUpPublishSettingPart troopTeamUpPublishSettingPart = this.this$0;
        b16.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpPublishSettingPart$deadlineConfig$2.b(string, troopTeamUpPublishSettingPart, view);
            }
        });
        x.c.g O = b16.O();
        String string2 = troopTeamUpPublishSettingPart.getContext().getString(R.string.f236407e_);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026up_publish_please_choose)");
        O.h(string2);
        return b16;
    }
}

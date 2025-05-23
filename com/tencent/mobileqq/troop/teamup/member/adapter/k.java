package com.tencent.mobileqq.troop.teamup.member.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/adapter/k;", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/h;", "Lcom/tencent/mobileqq/troop/teamup/member/data/b;", "data", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "memberTitle", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView memberTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.z27);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.member_title)");
        this.memberTitle = (TextView) findViewById;
    }

    @Override // com.tencent.mobileqq.troop.teamup.member.adapter.h
    @SuppressLint({"SetTextI18n"})
    public void l(@NotNull com.tencent.mobileqq.troop.teamup.member.data.b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof com.tencent.mobileqq.troop.teamup.member.data.d)) {
            return;
        }
        TextView textView = this.memberTitle;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.itemView.getResources().getString(R.string.f235807cn);
        Intrinsics.checkNotNullExpressionValue(string, "itemView.resources.getSt\u2026.troop_team_up_apply_num)");
        com.tencent.mobileqq.troop.teamup.member.data.d dVar = (com.tencent.mobileqq.troop.teamup.member.data.d) data;
        String format = String.format(string, Arrays.copyOf(new Object[]{dVar.c() + "/" + dVar.b()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }
}

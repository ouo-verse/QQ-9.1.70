package com.tencent.mobileqq.troop.troopblacklist.view.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/view/viewholder/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/troopblacklist/model/b;", "model", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "indexTextView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView indexTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.f101445v8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.troop_black_item_bar_tv)");
        this.indexTextView = (TextView) findViewById;
    }

    public final void l(@NotNull com.tencent.mobileqq.troop.troopblacklist.model.b model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        this.indexTextView.setText(model.b() + "\uff08" + model.a() + "\u4eba\uff09");
    }
}

package com.tencent.qqnt.chathistory.ui.date.adapter;

import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.datepicker.view.DateMonthView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/date/adapter/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/datepicker/view/DateMonthView;", "E", "Lcom/tencent/qqnt/datepicker/view/DateMonthView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/datepicker/view/DateMonthView;", "monthView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "setTvDate", "(Landroid/widget/TextView;)V", "tvDate", "G", "p", "tvDateLabel", "Landroid/view/View;", "H", "Landroid/view/View;", "l", "()Landroid/view/View;", "dividerLine", "itemView", "<init>", "(Landroid/view/View;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final DateMonthView monthView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private TextView tvDate;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView tvDateLabel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final View dividerLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.udz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.dateMonthView)");
        this.monthView = (DateMonthView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f10513657);
        TextView textView = (TextView) findViewById2;
        TextPaint paint = textView.getPaint();
        paint = paint instanceof TextPaint ? paint : null;
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById<Te\u2026akeBoldText = true\n     }");
        this.tvDate = textView;
        View findViewById3 = itemView.findViewById(R.id.f1053965w);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById<TextView>(R.id.tvMonthLabel)");
        this.tvDateLabel = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.f1053665t);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tvLine)");
        this.dividerLine = findViewById4;
    }

    @NotNull
    public final View l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.dividerLine;
    }

    @NotNull
    public final DateMonthView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DateMonthView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.monthView;
    }

    @NotNull
    public final TextView o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TextView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.tvDate;
    }

    @NotNull
    public final TextView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TextView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.tvDateLabel;
    }
}

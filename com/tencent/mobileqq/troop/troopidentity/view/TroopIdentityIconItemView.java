package com.tencent.mobileqq.troop.troopidentity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/view/TroopIdentityIconItemView;", "Landroid/widget/RelativeLayout;", "", "isSelect", "", "a", "b", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "d", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "def", "Landroid/view/View;", "contentView", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityIconItemView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUICheckBox checkbox;

    public /* synthetic */ TroopIdentityIconItemView(Context context, AttributeSet attributeSet, int i3, View view, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), view, Integer.valueOf(i16), defaultConstructorMarker);
    }

    public final void a(boolean isSelect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isSelect);
        } else if (isSelect) {
            setBackground(getContext().getDrawable(R.drawable.lwa));
            this.checkbox.setVisibility(0);
        } else {
            setBackground(getContext().getDrawable(R.drawable.lwb));
            this.checkbox.setVisibility(8);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            setBackground(null);
            this.checkbox.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopIdentityIconItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3, @NotNull View contentView) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, ctx, attributeSet, Integer.valueOf(i3), contentView);
            return;
        }
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ab.e(this, ViewUtils.dpToPx(5.0f));
        int dpToPx = ViewUtils.dpToPx(8.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            int i16 = layoutParams2 != null ? layoutParams2.width : -2;
            ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, layoutParams3 != null ? layoutParams3.height : -2);
        }
        if (dpToPx != marginLayoutParams.bottomMargin) {
            marginLayoutParams.bottomMargin = dpToPx;
            setLayoutParams(marginLayoutParams);
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = ViewUtils.dpToPx(16.0f);
        layoutParams4.bottomMargin = ViewUtils.dpToPx(16.0f);
        layoutParams4.addRule(13);
        addView(contentView, layoutParams4);
        QUICheckBox qUICheckBox = new QUICheckBox(ctx);
        this.checkbox = qUICheckBox;
        qUICheckBox.setId(R.id.axa);
        qUICheckBox.setType(0);
        qUICheckBox.setSizeType(2);
        qUICheckBox.setEnabled(true);
        qUICheckBox.setClickable(false);
        qUICheckBox.setChecked(true);
        qUICheckBox.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        layoutParams5.setMarginEnd(ViewUtils.dpToPx(6.0f));
        layoutParams5.topMargin = ViewUtils.dpToPx(6.0f);
        layoutParams5.addRule(10);
        layoutParams5.addRule(11);
        addView(qUICheckBox, layoutParams5);
        a(false);
    }
}

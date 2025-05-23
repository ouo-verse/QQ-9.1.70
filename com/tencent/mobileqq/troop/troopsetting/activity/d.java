package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.o;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ>\u0010\n\u001a\u00020\t2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0004`\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0014\u0010\u0016\u001a\u00020\t*\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0014R\u0017\u0010\u001b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/activity/d;", "", "Ljava/util/HashMap;", "", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "itemViews", "", "groupViewTags", "", h.F, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/widget/FormItemRelativeLayout;", "d", "e", "c", "itemView", "f", "Landroid/widget/LinearLayout;", "", "heightDp", "a", "b", "I", "g", "()I", "extNickHeight", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f301060a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int extNickHeight;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60066);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f301060a = new d();
            extNickHeight = ViewUtils.dpToPx(5.0f);
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void b(d dVar, LinearLayout linearLayout, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 16.0f;
        }
        dVar.a(linearLayout, f16);
    }

    @JvmStatic
    @NotNull
    public static final FormItemRelativeLayout c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        FormItemRelativeLayout formItemRelativeLayout = new FormItemRelativeLayout(context);
        formItemRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        formItemRelativeLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.common_strip_setting_bg, null));
        formItemRelativeLayout.setClickable(true);
        formItemRelativeLayout.setMinimumHeight(resources.getDimensionPixelSize(R.dimen.f158564j2));
        TextView textView = new TextView(context);
        textView.setId(R.id.title);
        textView.setDuplicateParentStateEnabled(true);
        textView.setSingleLine(true);
        textView.setMinWidth(ViewUtils.dpToPx(24.0f));
        textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), ViewUtils.dpToPx(7.0f));
        textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.f158563j1));
        textView.setText(R.string.es6);
        textView.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_primary, null));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = ViewUtils.dpToPx(15.0f);
        layoutParams.leftMargin = resources.getDimensionPixelSize(R.dimen.f159603b10);
        formItemRelativeLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.abv);
        textView2.setDuplicateParentStateEnabled(true);
        textView2.setLineSpacing(ViewUtils.dpToPx(5.0f), textView2.getLineSpacingMultiplier());
        textView2.setMaxLines(3);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(false);
        textView2.setTextSize(0, resources.getDimensionPixelSize(R.dimen.f158570j9));
        textView2.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_secondary, null));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.addRule(3, R.id.title);
        layoutParams2.addRule(5, R.id.title);
        layoutParams2.addRule(0, R.id.f164472yw);
        layoutParams2.rightMargin = ViewUtils.dpToPx(1.0f);
        layoutParams2.bottomMargin = ViewUtils.dpToPx(15.0f);
        formItemRelativeLayout.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(context);
        textView3.setId(R.id.i_f);
        textView3.setDuplicateParentStateEnabled(true);
        textView3.setSingleLine(true);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setText(R.string.rcv);
        textView3.setTextSize(0, resources.getDimensionPixelSize(R.dimen.f158570j9));
        textView3.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_secondary, null));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = ViewUtils.dpToPx(3.5f);
        layoutParams3.addRule(0, R.id.f164472yw);
        formItemRelativeLayout.addView(textView3, layoutParams3);
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.f164472yw);
        imageView.setImageResource(R.drawable.qui_chevron_right_icon_secondary_01);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.rightMargin = ViewUtils.dpToPx(12.5f);
        layoutParams4.topMargin = ViewUtils.dpToPx(2.0f);
        formItemRelativeLayout.addView(imageView, layoutParams4);
        return formItemRelativeLayout;
    }

    @JvmStatic
    @NotNull
    public static final FormItemRelativeLayout d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        FormItemRelativeLayout formItemRelativeLayout = new FormItemRelativeLayout(context);
        formItemRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        formItemRelativeLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.common_strip_setting_bg, null));
        formItemRelativeLayout.setClickable(true);
        formItemRelativeLayout.setMinimumHeight(resources.getDimensionPixelSize(R.dimen.f158564j2));
        TextView textView = new TextView(context);
        textView.setId(R.id.title);
        textView.setDuplicateParentStateEnabled(true);
        textView.setSingleLine(true);
        textView.setMinWidth(ViewUtils.dpToPx(24.0f));
        textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), ViewUtils.dpToPx(7.0f));
        textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.f158563j1));
        textView.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_primary, null));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = ViewUtils.dpToPx(15.0f);
        layoutParams.leftMargin = resources.getDimensionPixelSize(R.dimen.f159603b10);
        formItemRelativeLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.abv);
        textView2.setDuplicateParentStateEnabled(true);
        textView2.setLineSpacing(ViewUtils.dpToPx(5.0f), textView2.getLineSpacingMultiplier());
        textView2.setMaxLines(3);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(false);
        textView2.setTextSize(0, resources.getDimensionPixelSize(R.dimen.f158570j9));
        textView2.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_secondary, null));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.addRule(3, R.id.title);
        layoutParams2.addRule(5, R.id.title);
        layoutParams2.addRule(0, R.id.f164472yw);
        layoutParams2.rightMargin = ViewUtils.dpToPx(1.0f);
        layoutParams2.bottomMargin = ViewUtils.dpToPx(15.0f);
        formItemRelativeLayout.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(context);
        textView3.setId(R.id.i_f);
        textView3.setDuplicateParentStateEnabled(true);
        textView3.setSingleLine(true);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setTextSize(0, resources.getDimensionPixelSize(R.dimen.f158570j9));
        textView3.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_secondary, null));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = ViewUtils.dpToPx(8.0f);
        layoutParams3.addRule(0, R.id.d_5);
        formItemRelativeLayout.addView(textView3, layoutParams3);
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.d_5);
        imageView.setImageResource(R.drawable.hvw);
        imageView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(40.0f), ViewUtils.dpToPx(15.0f));
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, R.id.d_6);
        layoutParams4.addRule(11, 0);
        layoutParams4.rightMargin = ViewUtils.dpToPx(8.0f);
        formItemRelativeLayout.addView(imageView, layoutParams4);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(R.id.d_6);
        imageView2.setImageResource(R.drawable.qui_qrcode_vas_icon_secondary);
        imageView2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        layoutParams5.addRule(15);
        layoutParams5.addRule(0, R.id.f164472yw);
        layoutParams5.addRule(11, 0);
        layoutParams5.rightMargin = ViewUtils.dpToPx(8.0f);
        formItemRelativeLayout.addView(imageView2, layoutParams5);
        ImageView imageView3 = new ImageView(context);
        imageView3.setId(R.id.f164472yw);
        imageView3.setImageResource(R.drawable.qui_chevron_right_icon_secondary_01);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        layoutParams6.addRule(11);
        layoutParams6.addRule(15);
        layoutParams6.rightMargin = ViewUtils.dpToPx(12.5f);
        layoutParams6.topMargin = ViewUtils.dpToPx(2.0f);
        formItemRelativeLayout.addView(imageView3, layoutParams6);
        return formItemRelativeLayout;
    }

    @JvmStatic
    @NotNull
    public static final FormItemRelativeLayout e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        FormItemRelativeLayout formItemRelativeLayout = new FormItemRelativeLayout(context);
        formItemRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        formItemRelativeLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.common_strip_setting_bg, null));
        formItemRelativeLayout.setClickable(false);
        formItemRelativeLayout.setMinimumHeight(resources.getDimensionPixelSize(R.dimen.f158564j2));
        TextView textView = new TextView(context);
        textView.setId(R.id.title);
        textView.setDuplicateParentStateEnabled(true);
        textView.setSingleLine(true);
        textView.setMinWidth(ViewUtils.dpToPx(24.0f));
        textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), ViewUtils.dpToPx(7.0f));
        textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.f158563j1));
        textView.setText(R.string.es6);
        textView.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_primary, null));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = ViewUtils.dpToPx(15.0f);
        layoutParams.leftMargin = resources.getDimensionPixelSize(R.dimen.f159603b10);
        formItemRelativeLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.abv);
        textView2.setDuplicateParentStateEnabled(true);
        textView2.setLineSpacing(ViewUtils.dpToPx(5.0f), textView2.getLineSpacingMultiplier());
        textView2.setMaxLines(3);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(false);
        textView2.setTextSize(0, resources.getDimensionPixelSize(R.dimen.f158570j9));
        textView2.setTextColor(ResourcesCompat.getColorStateList(resources, R.color.qui_common_text_secondary, null));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.addRule(3, R.id.title);
        layoutParams2.addRule(5, R.id.title);
        layoutParams2.addRule(0, R.id.j9_);
        layoutParams2.rightMargin = ViewUtils.dpToPx(1.0f);
        layoutParams2.bottomMargin = ViewUtils.dpToPx(15.0f);
        formItemRelativeLayout.addView(textView2, layoutParams2);
        Switch r06 = new Switch(context);
        r06.setId(R.id.j9_);
        r06.setDuplicateParentStateEnabled(true);
        r06.setChecked(false);
        r06.setEnabled(true);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(21);
        layoutParams3.addRule(6, R.id.title);
        layoutParams3.setMarginEnd(ViewUtils.dpToPx(17.0f));
        layoutParams3.topMargin = ViewUtils.dpToPx(2.0f);
        formItemRelativeLayout.addView(r06, layoutParams3);
        return formItemRelativeLayout;
    }

    @JvmStatic
    public static final void f(@NotNull View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R.id.title);
        TextView textView2 = (TextView) itemView.findViewById(R.id.i_f);
        if (textView != null && textView2 != null && !TextUtils.isEmpty(textView.getText())) {
            int measureText = (int) textView.getPaint().measureText(textView.getText().toString());
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            ((RelativeLayout.LayoutParams) layoutParams).leftMargin = measureText + x.c(itemView.getContext(), 30.0f);
        }
    }

    @JvmStatic
    public static final void h(@NotNull HashMap<Integer, ? extends View> itemViews, @NotNull List<Integer> groupViewTags) {
        int i3;
        int lastIndex;
        boolean z16;
        Intrinsics.checkNotNullParameter(itemViews, "itemViews");
        Intrinsics.checkNotNullParameter(groupViewTags, "groupViewTags");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = groupViewTags.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            View view = itemViews.get(Integer.valueOf(((Number) next).intValue()));
            if (view != null) {
                if (view.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i3 = 1;
                }
            }
            if (i3 != 0) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == 1) {
            o.m(itemViews.get(arrayList.get(0)), 0, true);
            return;
        }
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) obj).intValue();
            if (i3 != 0) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                if (i3 == lastIndex) {
                    o.m(itemViews.get(Integer.valueOf(intValue)), 3, true);
                } else {
                    o.m(itemViews.get(Integer.valueOf(intValue)), 2, true);
                }
            } else {
                o.m(itemViews.get(Integer.valueOf(intValue)), 1, true);
            }
            i3 = i16;
        }
    }

    public final void a(@NotNull LinearLayout linearLayout, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, linearLayout, Float.valueOf(f16));
        } else {
            Intrinsics.checkNotNullParameter(linearLayout, "<this>");
            linearLayout.addView(new View(linearLayout.getContext()), new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(f16)));
        }
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return extNickHeight;
    }
}

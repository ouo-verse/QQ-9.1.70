package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.widget.labelv2.TroopLabelItemLayout;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/c;", "", "Landroid/graphics/drawable/GradientDrawable;", "c", "Landroid/content/Context;", "context", "", "activityName", "Landroid/view/View;", "d", "a", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f180933a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50150);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f180933a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final GradientDrawable c() {
        String str;
        if (!QQTheme.isNowThemeIsNight()) {
            str = "#E6F5FF";
        } else {
            str = "#004573";
        }
        int parseColor = Color.parseColor(str);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(ViewUtils.dip2px(3.0f));
        return gradientDrawable;
    }

    @NotNull
    public final View a(@NotNull Context context, @NotNull String activityName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) activityName);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        int color = ContextCompat.getColor(context, R.color.qui_common_brand_standard);
        TroopLabelItemLayout troopLabelItemLayout = new TroopLabelItemLayout(context);
        troopLabelItemLayout.setBackground(c());
        troopLabelItemLayout.b().setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.qui_hash_tag_brand_standard, null));
        TextView a16 = troopLabelItemLayout.a();
        a16.setTextColor(color);
        a16.setText(activityName);
        return troopLabelItemLayout;
    }

    @NotNull
    public final View b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, x.c(context, 1.0f));
        ImageView imageView = new ImageView(context);
        imageView.setBackground(ContextCompat.getDrawable(context, R.drawable.qui_common_border_standard_bg));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int c16 = x.c(context, 25.0f);
        linearLayout.setPadding(c16, 0, c16, 0);
        linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.qui_common_fill_light_primary_bg));
        linearLayout.addView(imageView, layoutParams);
        return linearLayout;
    }

    @NotNull
    public final View d(@NotNull Context context, @NotNull String activityName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) activityName);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        int color = ContextCompat.getColor(context, R.color.qui_common_brand_standard);
        TroopLabelItemLayout troopLabelItemLayout = new TroopLabelItemLayout(context);
        troopLabelItemLayout.setBackground(c());
        troopLabelItemLayout.b().setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.qui_dazi_activity_brand_standard, null));
        TextView a16 = troopLabelItemLayout.a();
        a16.setTextColor(color);
        a16.setText(activityName);
        troopLabelItemLayout.c().setVisibility(0);
        return troopLabelItemLayout;
    }
}

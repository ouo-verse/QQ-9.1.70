package com.tencent.mobileqq.weather.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eB#\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b\u001a\u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/WeatherConstellationItemViewHolder;", "Landroid/widget/FrameLayout;", "", "c", "", "isNightTheme", "b", "", "name", "isSelected", "a", "d", "Landroid/widget/FrameLayout;", "mConstellationIconContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mConstellationIcon", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mConstellationName", tl.h.F, "mConstellationDate", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherConstellationItemViewHolder extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mConstellationIconContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mConstellationIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mConstellationName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mConstellationDate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherConstellationItemViewHolder(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private final void b(boolean isNightTheme) {
        if (isNightTheme) {
            TextView textView = this.mConstellationName;
            FrameLayout frameLayout = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConstellationName");
                textView = null;
            }
            textView.setTextColor(-1);
            FrameLayout frameLayout2 = this.mConstellationIconContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConstellationIconContainer");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setBackground(getResources().getDrawable(R.drawable.f161918l02));
        }
    }

    private final void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.h75, this);
        View findViewById = inflate.findViewById(R.id.u5r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026on_select_icon_container)");
        this.mConstellationIconContainer = (FrameLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.u5q);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026onstellation_select_icon)");
        this.mConstellationIcon = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.u5u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026onstellation_select_name)");
        this.mConstellationName = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.u5o);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026onstellation_select_date)");
        this.mConstellationDate = (TextView) findViewById4;
    }

    public final void a(@NotNull String name, boolean isSelected) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, name, Boolean.valueOf(isSelected));
            return;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        TextView textView = this.mConstellationName;
        FrameLayout frameLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConstellationName");
            textView = null;
        }
        textView.setText(name);
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        if (gVar.e().containsKey(name)) {
            TextView textView2 = this.mConstellationDate;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConstellationDate");
                textView2 = null;
            }
            textView2.setText(gVar.e().get(name));
        }
        boolean g16 = com.tencent.mobileqq.weather.util.b.g();
        if (gVar.f().containsKey(name)) {
            String m3 = gVar.m(name, isSelected, g16);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            if (!TextUtils.isEmpty(m3)) {
                URLDrawable drawable = URLDrawable.getDrawable(m3, obtain);
                ImageView imageView = this.mConstellationIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mConstellationIcon");
                    imageView = null;
                }
                imageView.setImageDrawable(drawable);
            }
        }
        b(g16);
        if (isSelected) {
            FrameLayout frameLayout2 = this.mConstellationIconContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConstellationIconContainer");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setBackground(getResources().getDrawable(R.drawable.f161919l03));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherConstellationItemViewHolder(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherConstellationItemViewHolder(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}

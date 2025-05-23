package com.tencent.mobileqq.widget.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUISearchBarResource {
    public static final QUISearchBarResource DEFAULT_RES = new QUISearchBarResource();
    public static final String TAG = "QUISearchBarResource";

    private String colorToHexStr(int i3) {
        try {
            return "#" + ("000000" + Integer.toHexString(i3)).substring(r4.length() - 6).toUpperCase();
        } catch (Exception e16) {
            QLog.d(TAG, 1, "colorToHexStr error : ", e16);
            return "";
        }
    }

    public Drawable getBackIcon(@NonNull QUISearchBar qUISearchBar) {
        return ie0.a.f().p(qUISearchBar.getContext(), R.drawable.qui_chevron_left, R.color.qui_common_icon_primary, qUISearchBar.getCurThemeId());
    }

    public Drawable getBackground(@NonNull QUISearchBar qUISearchBar) {
        int i3;
        ie0.a f16 = ie0.a.f();
        Context context = qUISearchBar.getContext();
        if (qUISearchBar.getCurColorType() == 1) {
            i3 = R.color.qui_common_fill_light_primary_stick;
        } else {
            i3 = R.color.qui_common_fill_light_primary;
        }
        int g16 = f16.g(context, i3, qUISearchBar.getCurThemeId());
        QLog.i(TAG, 1, "background:" + colorToHexStr(g16));
        return new ColorDrawable(g16);
    }

    public ColorStateList getCancelColor(@NonNull QUISearchBar qUISearchBar) {
        return ie0.a.f().h(qUISearchBar.getContext(), R.color.qui_common_text_link_selector, qUISearchBar.getCurThemeId());
    }

    public Drawable getClearIcon(@NonNull QUISearchBar qUISearchBar) {
        return ie0.a.f().p(qUISearchBar.getContext(), R.drawable.qui_close_filled, R.color.qui_common_icon_secondary, qUISearchBar.getCurThemeId());
    }

    public Drawable getCursorDrawable(@NonNull QUISearchBar qUISearchBar) {
        GradientDrawable gradientDrawable = (GradientDrawable) ie0.a.f().k(qUISearchBar.getContext(), R.color.qui_common_brand_standard, 0.0f, qUISearchBar.getCurThemeId());
        gradientDrawable.setSize(ViewUtils.dpToPx(1.0f), ViewUtils.dpToPx(18.0f));
        return gradientDrawable;
    }

    public int getHighlightColor(@NonNull QUISearchBar qUISearchBar) {
        return ie0.a.f().g(qUISearchBar.getContext(), R.color.qui_common_brand_light, qUISearchBar.getCurThemeId());
    }

    public int getHintTextColor(@NonNull QUISearchBar qUISearchBar) {
        return ie0.a.f().g(qUISearchBar.getContext(), R.color.qui_common_text_secondary, qUISearchBar.getCurThemeId());
    }

    public Drawable getInputBackground(@NonNull QUISearchBar qUISearchBar) {
        int i3;
        ie0.a f16 = ie0.a.f();
        Context context = qUISearchBar.getContext();
        if (qUISearchBar.getCurColorType() == 1) {
            i3 = R.color.qui_common_fill_light_tertiary;
        } else {
            i3 = R.color.qui_common_fill_standard_brand;
        }
        return f16.k(context, i3, ViewUtils.dpToPx(4.0f), qUISearchBar.getCurThemeId());
    }

    public Drawable getSearchIcon(@NonNull QUISearchBar qUISearchBar) {
        return ie0.a.f().o(qUISearchBar.getContext(), R.drawable.qui_search, R.color.qui_common_icon_secondary, qUISearchBar.getCurThemeId());
    }

    public int getTextColor(@NonNull QUISearchBar qUISearchBar) {
        return ie0.a.f().g(qUISearchBar.getContext(), R.color.qui_common_text_primary, qUISearchBar.getCurThemeId());
    }
}

package com.tencent.mobileqq.profilecard.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.view.DrawableTextView;
import java.util.List;

/* loaded from: classes35.dex */
public class ProfileInStepCardTextHelper {
    private static final float TEXT_ALPHA = 0.6f;
    private static final float TEXT_SIZE = 17.0f;

    public static void generateSubTitle(ViewGroup viewGroup, List<String> list) {
        if ((list == null ? 0 : list.size()) == 0 || viewGroup == null || viewGroup.getChildCount() > 0) {
            return;
        }
        Context context = viewGroup.getContext();
        Resources resources = context.getResources();
        for (String str : list) {
            DrawableTextView drawableTextView = new DrawableTextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.d_c), -2);
            layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.f158723nd);
            drawableTextView.setLayoutParams(layoutParams);
            drawableTextView.setTextSize(17.0f);
            drawableTextView.setTextColor(resources.getColor(R.color.qui_common_text_primary));
            drawableTextView.setLineSpacing(resources.getDimensionPixelSize(R.dimen.d_9), 1.0f);
            drawableTextView.setText(str);
            drawableTextView.setAlpha(TEXT_ALPHA);
            drawableTextView.setCompoundDrawablePadding(resources.getDimensionPixelSize(R.dimen.f158700mp));
            drawableTextView.setCompoundDrawables(resources.getDrawable(R.drawable.qui_textview_drawable_left_dot), null, null, null);
            viewGroup.addView(drawableTextView);
        }
    }
}

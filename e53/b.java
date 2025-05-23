package e53;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QUIDrawableTextView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public static void a(ViewGroup viewGroup, List<String> list) {
        int size;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        if (size != 0 && viewGroup != null && viewGroup.getChildCount() <= 0) {
            Context context = viewGroup.getContext();
            Resources resources = context.getResources();
            for (String str : list) {
                QUIDrawableTextView qUIDrawableTextView = new QUIDrawableTextView(context);
                qUIDrawableTextView.setLayoutParams(new LinearLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.d_c), -2));
                qUIDrawableTextView.setTextSize(17.0f);
                qUIDrawableTextView.setTextColor(resources.getColor(R.color.qui_common_text_primary));
                qUIDrawableTextView.setLineSpacing(resources.getDimensionPixelSize(R.dimen.d_9), 1.0f);
                qUIDrawableTextView.setText(str);
                qUIDrawableTextView.setAlpha(0.6f);
                qUIDrawableTextView.setCompoundDrawablePadding(resources.getDimensionPixelSize(R.dimen.f158700mp));
                qUIDrawableTextView.setCompoundDrawables(resources.getDrawable(R.drawable.qui_textview_drawable_left_dot), null, null, null);
                viewGroup.addView(qUIDrawableTextView);
            }
        }
    }
}

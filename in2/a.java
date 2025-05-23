package in2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.widget.SingleLineTextView;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    public static void a(Context context, SingleLineTextView singleLineTextView, String str) {
        if (singleLineTextView != null && !TextUtils.isEmpty(str) && context != null) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if ((runtime instanceof QQAppInterface) && k.l((QQAppInterface) runtime, str)) {
                Drawable b16 = b(context);
                if (b16 != null) {
                    b16.setBounds(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f));
                    singleLineTextView.setCompoundDrawablePadding((int) al.a(context, 5.0f));
                    singleLineTextView.setDrawableRight2(b16);
                    return;
                }
                return;
            }
            singleLineTextView.setDrawableRight2WithIntrinsicBounds(null);
        }
    }

    public static Drawable b(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDrawable(R.drawable.qq_troop_bot_icon);
    }
}

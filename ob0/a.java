package ob0;

import android.app.Activity;
import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static ActionSheet a(Context context) {
        return ActionSheet.create(context, -1, null, false);
    }

    public static void b(Activity activity, ActionSheet actionSheet) {
        if (activity != null && actionSheet != null) {
            try {
                if (!activity.isFinishing()) {
                    actionSheet.dismiss();
                } else {
                    QLog.e(ActionSheetHelper.TAG, 1, "dismissActionSheet when activity(" + activity + ") is finish!");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}

package pb2;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a {
    public static QQCustomDialog a(Activity activity, String str, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, str, i3, i16, onClickListener, onClickListener2);
        if (createCustomDialog != null) {
            ((TextView) createCustomDialog.findViewById(R.id.bit)).setVisibility(8);
        }
        return createCustomDialog;
    }
}

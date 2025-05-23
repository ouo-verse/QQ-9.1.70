package fa1;

import android.R;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e implements b {
    @Override // fa1.b
    public int getType() {
        return R.dimen.app_icon_size;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        String subType = colorNote.getSubType();
        String[] split = subType.split("-");
        if (split.length > 0) {
            subType = split[0];
        }
        if (split.length > 1) {
            String str = split[1];
        }
        try {
            QfavHelper.v(context, "", Long.parseLong(subType), colorNote.getReserve());
        } catch (NumberFormatException e16) {
            QLog.i("QFavLauncher", 1, "[launch]:", e16);
        }
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}

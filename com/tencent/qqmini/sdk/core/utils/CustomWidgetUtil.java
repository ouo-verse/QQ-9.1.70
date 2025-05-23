package com.tencent.qqmini.sdk.core.utils;

import android.widget.TextView;
import com.tencent.qqmini.sdk.R;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CustomWidgetUtil {
    private static final int MAX_NOTE_NUM = 99;

    public static boolean equalsWithNullCheck(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static void updateCustomNoteTxt(TextView textView, int i3) {
        String valueOf;
        if (i3 > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(i3);
        }
        int i16 = R.id.mini_sdk_unreadmsg;
        Object tag = textView.getTag(i16);
        if (tag != null && (!(tag instanceof Integer) || ((Integer) tag).intValue() != 0)) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView.setTag(i16, 0);
            textView.setText(valueOf);
            textView.setPadding(0, 0, 0, 0);
        }
        textView.setBackgroundResource(R.drawable.mini_sdk_skin_tips_newmessage);
        if (!equalsWithNullCheck(textView.getText().toString(), valueOf)) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView.setText(valueOf);
        }
    }
}

package ay0;

import android.text.SpannableStringBuilder;
import com.tencent.icgame.game.utils.g;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {
    public static void a(String str, Object... objArr) {
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (i3 > 0) {
                spannableStringBuilder.append((CharSequence) "_");
            }
            Object obj = objArr[i3];
            if (obj != null) {
                str2 = obj.toString();
            } else {
                str2 = "null";
            }
            spannableStringBuilder.append((CharSequence) str2);
        }
        g.d("ICGameTRTCRoom", str + ":" + spannableStringBuilder.toString());
    }
}

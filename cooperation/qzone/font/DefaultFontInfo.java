package cooperation.qzone.font;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DefaultFontInfo {
    public final String TAG = "DefaultFontInfo";
    public int fontId;
    public String fontUrl;
    public int formatType;

    public void readFrom(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length >= 3) {
            try {
                this.fontId = Integer.valueOf(split[0]).intValue();
                this.formatType = Integer.valueOf(split[1]).intValue();
                this.fontUrl = split[2];
            } catch (Throwable th5) {
                QLog.e("DefaultFontInfo", 1, "loadDefaultFontData Throwable, errMsg = " + th5.getMessage());
            }
        }
    }

    public String toString() {
        if (TextUtils.isEmpty(this.fontUrl)) {
            return "";
        }
        return this.fontId + ";" + this.formatType + ";" + this.fontUrl + ";";
    }
}

package cooperation.qzone.font;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SimpleFontInfo extends DefaultFontInfo {
    public boolean hasFont() {
        if (this.fontId > 0 && !TextUtils.isEmpty(this.fontUrl)) {
            return true;
        }
        return false;
    }
}

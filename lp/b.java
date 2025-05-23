package lp;

import com.qzonex.utils.richtext.element.HighlightElement;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static HighlightElement a(String str) {
        int indexOf = str.indexOf("[hlt]");
        int indexOf2 = str.indexOf("[/hlt]");
        if (indexOf == -1 || indexOf2 == -1) {
            return null;
        }
        HighlightElement highlightElement = new HighlightElement();
        highlightElement.text = str.substring(indexOf + 5, indexOf2);
        return highlightElement;
    }
}

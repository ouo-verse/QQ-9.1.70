package h53;

import com.tencent.mobileqq.text.QQTextBuilder;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends QQTextBuilder {
    public b(CharSequence charSequence, int i3, int i16) {
        super(charSequence, i3, i16);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public char charAt(int i3) {
        if (i3 >= 0 && i3 < length()) {
            return super.charAt(i3);
        }
        return (char) 0;
    }
}

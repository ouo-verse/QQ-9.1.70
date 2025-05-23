package com.tencent.mobileqq.text;

import android.text.Editable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o extends QQTextBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static Editable.Factory f292704d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Editable.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
            }
            if (charSequence instanceof o) {
                return (Editable) charSequence;
            }
            return new o(charSequence, 3, 20);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements Comparator {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
            }
            int spanStart = o.this.getSpanStart(obj);
            int spanStart2 = o.this.getSpanStart(obj2);
            if (spanStart == spanStart2) {
                return 0;
            }
            if (spanStart > spanStart2) {
                return 1;
            }
            return -1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f292704d = new a();
        }
    }

    public o(CharSequence charSequence, int i3) {
        super(charSequence, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bc, code lost:
    
        r3.append(r1, r9, r0 - r9);
     */
    @Override // com.tencent.mobileqq.text.QQTextBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toPlainText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        int length = length();
        char[] cArr = new char[length];
        getChars(0, length, cArr, 0);
        StringBuilder sb5 = new StringBuilder(length);
        try {
            EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) getSpans(0, length, EmoticonSpan.class);
            Arrays.sort(emoticonSpanArr, new b());
            int length2 = emoticonSpanArr.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length2) {
                EmoticonSpan emoticonSpan = emoticonSpanArr[i3];
                int spanStart = getSpanStart(emoticonSpan);
                int spanEnd = getSpanEnd(emoticonSpan);
                if (emoticonSpan == null || spanStart >= spanEnd || spanEnd <= 0) {
                    break;
                }
                if (spanStart > i16) {
                    sb5.append(cArr, i16, spanStart - i16);
                }
                int i17 = emoticonSpan.emojiType;
                if (i17 != 0) {
                    if (i17 != 1) {
                        if (i17 == 2) {
                            sb5.append(emoticonSpan.getDescription());
                        }
                    } else {
                        String faceDescription = QQSysFaceUtil.getFaceDescription(emoticonSpan.index & Integer.MAX_VALUE);
                        if (!android.text.TextUtils.isEmpty(faceDescription)) {
                            sb5.append(faceDescription);
                        } else {
                            QLog.e("QzoneTextBuilder", 1, "\u4e0d\u652f\u6301\u7684\u8868\u60c5");
                        }
                    }
                } else {
                    int emojiUnicode = QQEmojiUtil.getEmojiUnicode(emoticonSpan.index);
                    if (emojiUnicode != -1) {
                        sb5.append(String.valueOf(Character.toChars(emojiUnicode)));
                    } else {
                        try {
                            String qQTextBuilder = toString();
                            if (!android.text.TextUtils.isEmpty(qQTextBuilder) && qQTextBuilder.length() >= spanEnd) {
                                sb5.append(qQTextBuilder.substring(spanStart, spanEnd));
                            }
                        } catch (Exception e16) {
                            QLog.e("QzoneTextBuilder", 1, e16.getStackTrace());
                        }
                    }
                }
                i3++;
                i16 = spanEnd;
            }
        } catch (Exception e17) {
            QLog.e(QQTextBuilder.TAG, 1, "toPlainText,exception:", e17, ", text:", sb5.toString());
        }
        return sb5.toString();
    }

    public o(CharSequence charSequence, int i3, int i16) {
        super(charSequence, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16));
    }
}

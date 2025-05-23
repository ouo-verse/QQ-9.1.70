package com.tencent.mobileqq.qzone.api.text;

import android.text.Editable;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends QQTextBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static Editable.Factory f279313d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qzone.api.text.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8488a extends Editable.Factory {
        static IPatchRedirector $redirector_;

        C8488a() {
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
            if (charSequence instanceof a) {
                return (Editable) charSequence;
            }
            return new a(charSequence, 3, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements Comparator {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
            }
            int spanStart = a.this.getSpanStart(obj);
            int spanStart2 = a.this.getSpanStart(obj2);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74449);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f279313d = new C8488a();
        }
    }

    public a(CharSequence charSequence, int i3) {
        super(charSequence, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence, i3);
    }

    private String a(int i3) {
        String eMCode = QQSysFaceUtil.getEMCode(i3);
        if (TextUtils.isEmpty(eMCode)) {
            QLog.e(QQTextBuilder.TAG, 1, "[getEMCode] error. localId: " + i3);
            return null;
        }
        return "[em]e" + eMCode + QzoneEmotionUtils.EMO_TAIL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c6, code lost:
    
        r3.append(r1, r6, r0 - r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(boolean z16) {
        String faceDescription;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
        int length = length();
        char[] cArr = new char[length];
        int i3 = 0;
        getChars(0, length, cArr, 0);
        StringBuilder sb5 = new StringBuilder(length);
        EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) getSpans(0, length, EmoticonSpan.class);
        Arrays.sort(emoticonSpanArr, new b());
        int length2 = emoticonSpanArr.length;
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
                    int i18 = Integer.MAX_VALUE & emoticonSpan.index;
                    if (z16) {
                        faceDescription = a(i18);
                    } else {
                        faceDescription = QQSysFaceUtil.getFaceDescription(i18);
                    }
                    if (!TextUtils.isEmpty(faceDescription)) {
                        sb5.append(faceDescription);
                    } else {
                        QLog.e("QzoneTextBuilder", 1, "\u4e0d\u652f\u6301\u7684\u8868\u60c5");
                        return toString();
                    }
                }
            } else {
                int emojiUnicode = QQEmojiUtil.getEmojiUnicode(emoticonSpan.index);
                if (emojiUnicode != -1) {
                    sb5.append(String.valueOf(Character.toChars(emojiUnicode)));
                } else {
                    try {
                        String qQTextBuilder = toString();
                        if (!TextUtils.isEmpty(qQTextBuilder) && qQTextBuilder.length() >= spanEnd) {
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
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.text.QQTextBuilder
    public String toPlainText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return b(false);
    }

    public a(CharSequence charSequence, int i3, int i16) {
        super(charSequence, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16));
    }
}

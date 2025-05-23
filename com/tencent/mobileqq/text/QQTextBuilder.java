package com.tencent.mobileqq.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.text.processor.ITextProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIChatTextSize;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQTextBuilder extends SpannableStringBuilder {
    static IPatchRedirector $redirector_ = null;
    public static Editable.Factory EMOCTATION_FACORY = null;
    public static Editable.Factory EMOTION_INPUT_FACTORY = null;

    @ConfigInject(configPath = "NTRuntime/Service/qqui_kit/src/main/resources/Inject_QQTextSpanProcessor.yml", version = 1)
    public static ArrayList<Class<? extends ITextProcessor>> ITextProcessorClassList = null;
    public static final String TAG = "QQTextBuilder";
    private static ArrayList<ITextProcessor> sTextProcessorList;
    private int mEmoSize;
    private int mflags;

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
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends Editable.Factory {
        static IPatchRedirector $redirector_;

        b() {
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
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 3, QQUIChatTextSize.getChatTextSizeWithDP() + 1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c extends Editable.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f292659a;

        c(int i3) {
            this.f292659a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
            }
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 3, this.f292659a);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51321);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        ArrayList<Class<? extends ITextProcessor>> arrayList = new ArrayList<>();
        ITextProcessorClassList = arrayList;
        arrayList.add(com.tencent.mobileqq.text.processor.b.class);
        sTextProcessorList = new ArrayList<>();
        Iterator<Class<? extends ITextProcessor>> it = ITextProcessorClassList.iterator();
        while (it.hasNext()) {
            try {
                sTextProcessorList.add(it.next().newInstance());
            } catch (IllegalAccessException e16) {
                QLog.e(TAG, 1, "initTextProcessor error! ", e16);
            } catch (InstantiationException e17) {
                QLog.e(TAG, 1, "initTextProcessor error! ", e17);
            }
        }
        EMOCTATION_FACORY = new a();
        EMOTION_INPUT_FACTORY = new b();
    }

    public QQTextBuilder(int i3) {
        this(i3, 32);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, i3);
    }

    private static final CharSequence convert(CharSequence charSequence, int i3, int i16) {
        if (charSequence instanceof QQText) {
            return ((QQText) charSequence).toSpanableString();
        }
        return new QQText(charSequence, i3, i16).toSpanableString();
    }

    public static Editable.Factory getCustomSizeEditableFactory(int i3) {
        return new c(i3);
    }

    protected QQText genQQText(CharSequence charSequence, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QQText) iPatchRedirector.redirect((short) 9, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return new QQText(charSequence, i3, i16);
    }

    @Override // android.text.SpannableStringBuilder, android.text.GetChars
    public void getChars(int i3, int i16, char[] cArr, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), cArr, Integer.valueOf(i17));
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int length = length();
        if (i16 > length) {
            i16 = length;
        }
        try {
            super.getChars(i3, i16, cArr, i17);
        } catch (IndexOutOfBoundsException e16) {
            QLog.e(TAG, 1, "text:" + toPlainText());
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        try {
            super.setSpan(obj, i3, i16, i17);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (!QQText.IS_FXXKED_MTK) {
            return super.subSequence(i3, i16);
        }
        if (i3 == 0 && i16 == length()) {
            return this;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int length = length();
        if (i16 > length) {
            i16 = length;
        }
        char[] cArr = new char[i16 - i3];
        getChars(i3, i16, cArr, 0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cArr);
        Iterator<ITextProcessor> it = sTextProcessorList.iterator();
        while (it.hasNext()) {
            it.next().doSubSequence(i3, i16, sb5, this);
        }
        return sb5;
    }

    public String toPlainText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        int length = length();
        char[] cArr = new char[length];
        getChars(0, length, cArr, 0);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cArr);
        Iterator<ITextProcessor> it = sTextProcessorList.iterator();
        while (it.hasNext()) {
            it.next().doToPlain(length, stringBuffer, this);
        }
        return stringBuffer.toString();
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (!QQText.IS_FXXKED_MTK) {
            return super.toString();
        }
        int length = length();
        char[] cArr = new char[length];
        getChars(0, length, cArr, 0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cArr);
        Iterator<ITextProcessor> it = sTextProcessorList.iterator();
        while (it.hasNext()) {
            it.next().doToString(length, sb5, this);
        }
        return sb5.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r6 != r2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String trim() {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        String qQTextBuilder = toString();
        char[] charArray = qQTextBuilder.toCharArray();
        int length = qQTextBuilder.length() - 1;
        int i3 = 0;
        while (i3 <= length && (c16 = charArray[i3]) <= ' ' && c16 != 20) {
            i3++;
        }
        int i16 = length;
        while (i16 >= i3 && charArray[i16] <= ' ' && (i16 == 0 || charArray[i16 - 1] != 20)) {
            i16--;
        }
        return qQTextBuilder.substring(i3, i16 + 1);
    }

    public QQTextBuilder(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mflags = i3;
            this.mEmoSize = i16;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i3, int i16, CharSequence charSequence, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), charSequence, Integer.valueOf(i17), Integer.valueOf(i18));
        }
        try {
            int max = Math.max(0, i3);
            i16 = Math.min(i16, length());
            if (i16 < 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "selection error, start = " + max + " end = " + i16 + " length = " + length());
                }
                i16 = 0;
            }
            if (charSequence.length() > 0) {
                charSequence = genQQText(charSequence, this.mflags, this.mEmoSize).toSpanableString();
            }
            return super.replace(max, i16, charSequence, i17, i18);
        } catch (Throwable th5) {
            QLog.e(QQText.TAG, 1, "QQTextBuilder.replace caused crash..text:" + toString() + ", replace text:" + ((Object) charSequence) + " , " + i3 + "-" + i16 + " , " + i17 + "-" + i18, th5);
            return new SpannableStringBuilder();
        }
    }

    public QQTextBuilder(CharSequence charSequence, int i3) {
        this(charSequence, i3, 32);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence, i3);
    }

    public QQTextBuilder(CharSequence charSequence, int i3, int i16) {
        super(convert(charSequence, i3, i16));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mEmoSize = i16;
            this.mflags = i3;
        }
    }
}

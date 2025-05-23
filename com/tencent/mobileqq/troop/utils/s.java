package com.tencent.mobileqq.troop.utils;

import android.os.Build;
import android.text.Spanned;
import android.widget.EditText;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f302200a;

    /* renamed from: b, reason: collision with root package name */
    protected static final String f302201b;

    /* renamed from: c, reason: collision with root package name */
    protected static final String f302202c;

    /* renamed from: d, reason: collision with root package name */
    protected static final String f302203d;

    /* renamed from: e, reason: collision with root package name */
    protected static final String f302204e;

    /* renamed from: f, reason: collision with root package name */
    protected static SimpleDateFormat f302205f;

    /* renamed from: g, reason: collision with root package name */
    public static Hashtable<String, TroopBarPublishUtils.Pic_list> f302206g;

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap<String, Object> f302207h;

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap<String, Object> f302208i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap<String, String> f302209j;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements Comparator<Object> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Spanned f302210d;

        a(Spanned spanned) {
            this.f302210d = spanned;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) spanned);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
            }
            return this.f302210d.getSpanStart(obj) - this.f302210d.getSpanStart(obj2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76704);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f302200a = "&_wv=1031&_bid=128&platform=android&from=native&version=" + AppSetting.f99551k;
        f302201b = HardCodeUtil.qqStr(R.string.f172805uc1);
        f302202c = HardCodeUtil.qqStr(R.string.uca);
        f302203d = HardCodeUtil.qqStr(R.string.ubs);
        f302204e = HardCodeUtil.qqStr(R.string.ubo);
        f302205f = new SimpleDateFormat();
        f302206g = new Hashtable<>();
        f302207h = new HashMap<>();
        f302208i = new HashMap<>();
        f302209j = new HashMap<>();
    }

    public static final String a(EditText editText) {
        QQTextBuilder qQTextBuilder;
        int spanStart;
        int spanEnd;
        int length;
        if (editText == null) {
            return null;
        }
        if ((editText.getEditableText() instanceof QQTextBuilder) && (qQTextBuilder = (QQTextBuilder) editText.getEditableText()) != null) {
            int length2 = qQTextBuilder.length();
            char[] cArr = new char[length2];
            qQTextBuilder.getChars(0, length2, cArr, 0);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(cArr);
            EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) qQTextBuilder.getSpans(0, length2, EmoticonSpan.class);
            if (Build.VERSION.SDK_INT >= 24) {
                Arrays.sort(emoticonSpanArr, new a(qQTextBuilder));
            }
            int i3 = 0;
            for (EmoticonSpan emoticonSpan : emoticonSpanArr) {
                int i16 = emoticonSpan.emojiType;
                if (i16 == 1) {
                    spanStart = qQTextBuilder.getSpanStart(emoticonSpan);
                    spanEnd = qQTextBuilder.getSpanEnd(emoticonSpan);
                    String faceDescription = QQSysFaceUtil.getFaceDescription(emoticonSpan.index & Integer.MAX_VALUE);
                    stringBuffer.replace(spanStart + i3, spanEnd + i3, faceDescription);
                    length = faceDescription.length();
                } else if (i16 == 2) {
                    spanStart = qQTextBuilder.getSpanStart(emoticonSpan);
                    spanEnd = qQTextBuilder.getSpanEnd(emoticonSpan);
                    String description = emoticonSpan.getDescription();
                    stringBuffer.replace(spanStart + i3, spanEnd + i3, description);
                    length = description.length();
                }
                i3 += length - (spanEnd - spanStart);
            }
            return stringBuffer.toString();
        }
        return editText.getEditableText().toString();
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6) {
        c("Grp_tribe", str, str2, str3, str4, str5, str6);
    }

    public static final void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        ReportController.o(null, "P_CliOper", str, "", str2, str3, 0, 0, str4, str5, str6, str7);
    }
}

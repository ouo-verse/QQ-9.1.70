package com.qzone.util;

import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes37.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    public static final StringBuffer f59786a;

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f59787b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f59788c;

    static {
        StringBuffer stringBuffer = new StringBuffer("\\[em\\]e\\d{1,}\\[/em\\]");
        f59786a = stringBuffer;
        f59787b = Pattern.compile(stringBuffer.toString(), 2);
        f59788c = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
    }

    public static void a(String str) {
        try {
            ((ClipboardManager) BaseApplication.getContext().getSystemService("clipboard")).setText(str);
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopySuccess", "\u590d\u5236\u6210\u529f"));
        } catch (Exception unused) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopyFail", "\u590d\u5236\u5931\u8d25"));
        }
    }

    public static String d(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str.toString().replace("\r\n", " ").replace("\n", " "), " ");
        StringBuffer stringBuffer = new StringBuffer();
        while (stringTokenizer.hasMoreTokens()) {
            stringBuffer.append(stringTokenizer.nextToken() + TokenParser.SP);
        }
        return stringBuffer.toString().trim();
    }

    public static int e(String str, int i3) {
        int length = str.length();
        int i16 = 0;
        int i17 = 0;
        while (i16 < length) {
            i16 += Character.charCount(str.codePointAt(i16));
            i17++;
            if (i17 >= i3) {
                return i16;
            }
        }
        return length;
    }

    public static String f(String str) {
        if (h(str)) {
            return "";
        }
        String str2 = File.separator;
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf == -1) {
            return str;
        }
        if (lastIndexOf == str.length() - 1) {
            return "";
        }
        String substring = str.substring(0, lastIndexOf);
        if (h(substring)) {
            return "";
        }
        int lastIndexOf2 = substring.lastIndexOf(str2);
        if (lastIndexOf2 == -1) {
            return substring;
        }
        if (lastIndexOf2 == substring.length() - 1) {
            return "";
        }
        return substring.substring(lastIndexOf2 + 1);
    }

    public static String i(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            RFWLog.e("StringUtil", RFWLog.USR, "not find similar string in target");
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        sb5.replace(indexOf, str2.length() + indexOf, str3);
        return sb5.toString();
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("%3A", ":").replace("%7D", "}").replace("%7B", "{").replace("%2C", ",").replace("%25", "%");
    }

    public static String c(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A");
    }

    public static void g(String str, int i3, EditText editText) {
        if (editText == null || TextUtils.isEmpty(str) || i3 < 0) {
            return;
        }
        Editable newEditable = com.tencent.mobileqq.text.o.f292704d.newEditable(editText.getText());
        newEditable.insert(i3, str);
        try {
            editText.setText(newEditable);
        } catch (IndexOutOfBoundsException unused) {
            newEditable.append((CharSequence) " ");
            editText.setText(newEditable);
        }
        try {
            editText.setSelection(Math.min(str.length() + i3, editText.length()));
        } catch (IndexOutOfBoundsException e16) {
            Editable text = editText.getText();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("insertStrToEdit error:");
            sb5.append(e16);
            sb5.append(",str:");
            sb5.append(str);
            sb5.append("start:");
            sb5.append(i3);
            sb5.append("tempStr:");
            sb5.append(newEditable.toString());
            sb5.append("editTextLength:");
            sb5.append(text != null ? text.length() : 0);
            QLog.e("StringUtil", 1, sb5.toString());
        }
    }

    public static boolean h(String str) {
        return str == null || str.length() == 0;
    }

    public static String j(String str, String str2, String str3) {
        try {
            String replaceFirst = Pattern.compile(str, 16).matcher(str2).replaceFirst(str3);
            return (!replaceFirst.contains(str) || replaceFirst.contains(str3)) ? replaceFirst : i(str2, str, str3);
        } catch (Exception e16) {
            QLog.e("StringUtil", 1, "replace exception is " + e16);
            return i(str2, str, str3);
        }
    }

    public static String k(String str, int i3) {
        if (str == null) {
            return null;
        }
        int e16 = e(str, i3);
        return e16 >= str.length() ? str : str.substring(0, e16);
    }
}

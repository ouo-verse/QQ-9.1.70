package com.tencent.mobileqq.filemanager.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f207742a = Integer.parseInt(AppConstants.PUBLIC_ACCOUNT_QQ_MAIL);

    /* renamed from: b, reason: collision with root package name */
    public static int f207743b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f207744c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static int f207745d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static int f207746e = 3;

    /* renamed from: f, reason: collision with root package name */
    public static int f207747f = 4;

    /* renamed from: g, reason: collision with root package name */
    public static int f207748g = 5;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f207749h = false;

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f207750i = {".doc|.docx|.wps|.pages|", ".xls|.xlsx|.et|.numbers|"};

    /* renamed from: j, reason: collision with root package name */
    public static final char[] f207751j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f207752k;

    /* renamed from: l, reason: collision with root package name */
    public static final char[] f207753l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f207754m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void onError(int i3, String str);

        void onSuccess();
    }

    static {
        char[] cArr = {Typography.ellipsis};
        f207751j = cArr;
        f207752k = new String(cArr);
        char[] cArr2 = {'\u2025'};
        f207753l = cArr2;
        f207754m = new String(cArr2);
    }

    public static final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("(https|http)?(://)?docs.qq.com/(doc)/.*", str);
    }

    public static final boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("(https|http)?(://)?docs.qq.com/(form/edit|form/fill|form/page)/.*", str);
    }

    public static final boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("(https|http)?(://)?docs.qq.com/(mind)/.*", str);
    }

    public static final boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("(https|http)?(://)?docs.qq.com/(pdf)/.*", str);
    }

    public static final boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("(https|http)?(://)?docs.qq.com/(slide)/.*", str);
    }

    public static final boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("(https|http)?(://)?docs.qq.com/(sheet)/.*", str);
    }

    public static final boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("(https|http)?(://)?docs.qq.com/(desktop|doc|sheet|slide|pdf|mall|smartsheet|flowchart|aio|board|document|form/edit|form/fill|form/page|mind)/.*", str);
    }
}

package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.EncryptUinHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.utils.c;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements EncryptUinHandler.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f239301a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f239302b;

        a(SharedPreferences sharedPreferences, String str) {
            this.f239301a = sharedPreferences;
            this.f239302b = str;
        }

        @Override // com.tencent.biz.pubaccount.EncryptUinHandler.c
        public void callback(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SharedPreferences.Editor edit = this.f239301a.edit();
            edit.putString("iid", this.f239302b);
            edit.putString(this.f239302b, str);
            edit.commit();
        }
    }

    @Deprecated
    public static AppRuntime a() {
        return com.tencent.mobileqq.kandian.base.utils.b.c();
    }

    public static int b(int i3, int i16, boolean z16) {
        if (!z16 && i16 != 0) {
            if (i3 + 1 == i16) {
                return 1;
            }
            return 0;
        }
        return -1;
    }

    public static String c() {
        SharedPreferences b16 = c.b(a(), true, true);
        if (b16 == null) {
            return "";
        }
        String string = b16.getString("iid", "");
        if (TextUtils.isEmpty(string)) {
            return e(b16, "");
        }
        if (TextUtils.equals(string, "")) {
            String string2 = b16.getString("", "");
            return TextUtils.isEmpty(string2) ? e(b16, "") : string2;
        }
        return e(b16, "");
    }

    public static Integer d(Context context, String str) {
        return p62.a.e(context, str);
    }

    private static String e(SharedPreferences sharedPreferences, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        EncryptUinHandler encryptUinHandler = new EncryptUinHandler((AppInterface) com.tencent.mobileqq.kandian.base.utils.b.c());
        encryptUinHandler.M2(new a(sharedPreferences, str));
        return encryptUinHandler.J2();
    }
}

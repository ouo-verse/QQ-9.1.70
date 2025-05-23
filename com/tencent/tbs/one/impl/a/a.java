package com.tencent.tbs.one.impl.a;

import android.content.Context;
import com.tencent.smtt.sdk.TbsConfig;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final EnumC9884a[] f374529a;

    /* renamed from: b, reason: collision with root package name */
    private static final EnumC9884a[] f374530b;

    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public enum EnumC9884a {
        Mm("com.tencent.mm"),
        Mqq("com.tencent.mobileqq"),
        Mtt(TbsConfig.APP_QB),
        SogouExplorer("sogou.mobile.explorer"),
        SogouReader("com.sogou.reader.free");


        /* renamed from: f, reason: collision with root package name */
        private final String f374537f;

        EnumC9884a(String str) {
            this.f374537f = str;
        }
    }

    static {
        EnumC9884a enumC9884a = EnumC9884a.Mqq;
        f374529a = new EnumC9884a[]{enumC9884a, EnumC9884a.Mtt, EnumC9884a.SogouExplorer, EnumC9884a.SogouReader};
        f374530b = new EnumC9884a[]{enumC9884a};
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return a(context, f374529a);
    }

    public static boolean a(Context context, EnumC9884a... enumC9884aArr) {
        if (enumC9884aArr != null && context != null) {
            for (EnumC9884a enumC9884a : enumC9884aArr) {
                if (context.getPackageName().equals(enumC9884a.f374537f)) {
                    return true;
                }
            }
        }
        return false;
    }
}

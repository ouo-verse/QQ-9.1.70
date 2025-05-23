package com.tencent.mobileqq.guild.util;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes14.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static int f235571a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f235572b = 2;

    private static Drawable a(int i3, boolean z16) {
        return ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getSysFaceDrawable(i3, z16);
    }

    public static Drawable b(int i3, int i16) {
        if (i16 == f235572b) {
            return c(i3);
        }
        if (i16 == f235571a) {
            return a(i3, true);
        }
        return null;
    }

    private static Drawable c(int i3) {
        return ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmojiDrawable(i3);
    }

    public static Drawable d(int i3, int i16) {
        if (i16 == f235572b) {
            return c(i3);
        }
        if (i16 == f235571a) {
            return a(i3, false);
        }
        return null;
    }

    public static String e(int i3, String str) {
        int intValue;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            intValue = Integer.valueOf(str).intValue();
        } catch (NumberFormatException unused) {
        }
        if (i3 == f235571a) {
            return QQSysFaceUtil.getFaceDescription(intValue);
        }
        if (i3 == f235572b) {
            return QQEmojiUtil.getEmojiDescription(intValue);
        }
        return "";
    }

    public static int f(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            int intValue = Integer.valueOf(str).intValue();
            if (i3 == f235571a) {
                return QQSysFaceUtil.convertToServer(intValue);
            }
            if (i3 != f235572b) {
                return -1;
            }
            return QQSysAndEmojiResMgr.getInstance().getResImpl(f235572b).getServerId(intValue);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int g(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            int intValue = Integer.valueOf(str).intValue();
            if (i3 == f235571a) {
                return QQSysFaceUtil.convertToLocal(intValue);
            }
            if (i3 != f235572b) {
                return -1;
            }
            return QQSysAndEmojiResMgr.getInstance().getResImpl(f235572b).getLocalId(intValue);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}

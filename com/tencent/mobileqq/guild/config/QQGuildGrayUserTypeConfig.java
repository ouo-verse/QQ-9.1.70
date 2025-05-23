package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Deprecated
/* loaded from: classes13.dex */
public class QQGuildGrayUserTypeConfig {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f216087b = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f216088a;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes13.dex */
    public @interface UserType {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f216089a;

        /* renamed from: b, reason: collision with root package name */
        public final QQGuildGrayUserTypeConfig f216090b;

        public a() {
            this(null, null);
        }

        public a(String str, QQGuildGrayUserTypeConfig qQGuildGrayUserTypeConfig) {
            this.f216089a = str;
            this.f216090b = qQGuildGrayUserTypeConfig;
        }
    }

    QQGuildGrayUserTypeConfig() {
        this.f216088a = 0;
        this.f216088a = bx.c();
    }

    public static synchronized QQGuildGrayUserTypeConfig a() {
        synchronized (QQGuildGrayUserTypeConfig.class) {
            String g16 = ch.g();
            if (TextUtils.equals(g16, f216087b.f216089a)) {
                return f216087b.f216090b;
            }
            f216087b = new a(g16, new QQGuildGrayUserTypeConfig());
            return f216087b.f216090b;
        }
    }

    private static boolean b(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    private static String d(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return String.valueOf(i3);
                        }
                        return "\u5df2\u9080\u8bf7\u5e76\u540c\u610f\u7528\u6237";
                    }
                    return "\u5185\u90e8\u7528\u6237";
                }
                return "KA\u7528\u6237";
            }
            return "\u5df2\u9080\u8bf7\u672a\u540c\u610f\u7528\u6237";
        }
        return "\u672a\u77e5\u7528\u6237";
    }

    public void c(int i3) {
        int i16 = i3 & 7;
        this.f216088a = i16;
        if (i16 == 1 && b(i3, 8)) {
            this.f216088a = 4;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.config.QQGuildGrayUserTypeConfig", 2, "update: ", Integer.toBinaryString(i3), " -> ", d(this.f216088a));
        }
        bx.p(this.f216088a);
    }

    @NonNull
    public String toString() {
        return "QQGuildGrayUserTypeConfig{mUserType=" + d(this.f216088a) + '}';
    }
}

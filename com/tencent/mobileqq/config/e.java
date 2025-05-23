package com.tencent.mobileqq.config;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import java.util.ArrayList;
import kotlin.text.Typography;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public static byte f202864b = 3;

    /* renamed from: c, reason: collision with root package name */
    public static byte f202865c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static g f202866d;

    /* renamed from: e, reason: collision with root package name */
    public static PicAndAdConf f202867e;

    /* renamed from: f, reason: collision with root package name */
    static PicAndAdConf f202868f;

    /* renamed from: g, reason: collision with root package name */
    static com.tencent.mobileqq.config.struct.b[] f202869g;

    /* renamed from: h, reason: collision with root package name */
    private static ArrayList<f> f202870h;

    /* renamed from: a, reason: collision with root package name */
    private boolean f202871a = true;

    public e(QQAppInterface qQAppInterface, String str) {
        f202866d = new g(qQAppInterface.getApp(), str);
        f202870h = new ArrayList<>();
        f202867e = new PicAndAdConf((short) 24, (byte) 0);
        PicAndAdConf picAndAdConf = new PicAndAdConf((short) 12, (byte) 1);
        f202868f = picAndAdConf;
        f202869g = new com.tencent.mobileqq.config.struct.b[]{f202867e, picAndAdConf};
        f202866d.f();
    }

    public static void a() {
        f202866d = null;
    }

    public static String b(String str, int i3, String str2) {
        StringBuffer stringBuffer = new StringBuffer(g.a(str, i3).trim());
        if (str2 != null) {
            String trim = str2.trim();
            if (trim.length() > 0) {
                if (trim.charAt(0) != '&') {
                    stringBuffer.append(Typography.amp);
                }
                stringBuffer.append(trim);
            }
        }
        return stringBuffer.toString();
    }

    public static ArrayList<f> d() {
        return f202870h;
    }

    public static g e() {
        return f202866d;
    }

    public static String l() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime != null) {
            return runtime.getAccount();
        }
        return null;
    }

    public long c(int i3, int i16) {
        return ((PicAndAdConf) f202869g[i3]).o(i16);
    }

    public Bitmap f(int i3, int i16) {
        return ((PicAndAdConf) f202869g[i3]).n(i16);
    }

    public String g(int i3, int i16) {
        return ((PicAndAdConf) f202869g[i3]).m(i16);
    }

    public String h(int i3, int i16) {
        return ((PicAndAdConf) f202869g[i3]).p(i16);
    }

    public String i(int i3, int i16) {
        return ((PicAndAdConf) f202869g[i3]).q(i16);
    }

    public short j(int i3, int i16) {
        return ((PicAndAdConf) f202869g[i3]).r(i16);
    }

    public int k(int i3) {
        return f202869g[i3].c();
    }
}

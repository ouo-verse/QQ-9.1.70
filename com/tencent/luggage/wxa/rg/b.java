package com.tencent.luggage.wxa.rg;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f139662c = new b("unknown");

    /* renamed from: d, reason: collision with root package name */
    public static final b f139663d = new b("application/octet-stream");

    /* renamed from: e, reason: collision with root package name */
    public static final b f139664e = new b("video/mp4");

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f139665f = {IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, 107, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM};

    /* renamed from: g, reason: collision with root package name */
    public static HashMap f139666g = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public String f139667a;

    /* renamed from: b, reason: collision with root package name */
    public String f139668b;

    public b(String str) {
        this.f139667a = str;
    }

    public static String b(String str) {
        try {
            return new String(com.tencent.luggage.wxa.tg.b.a(str), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return f139662c.toString();
        }
    }

    public static String c(String str) {
        try {
            return com.tencent.luggage.wxa.tg.b.a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return com.tencent.luggage.wxa.tg.b.a(f139665f);
        }
    }

    public static b d(String str) {
        if (TextUtils.isEmpty(str)) {
            return f139662c;
        }
        if (str.equals("video/mp4")) {
            return f139664e;
        }
        if (str.equals("unknown")) {
            return f139662c;
        }
        return new b(str);
    }

    public String a() {
        if (TextUtils.isEmpty(this.f139668b)) {
            String c16 = c(this.f139667a);
            this.f139668b = c16;
            return c16;
        }
        return this.f139668b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f139667a;
        String str2 = ((b) obj).f139667a;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f139667a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return this.f139667a;
    }

    public static b a(String str) {
        if (f139666g.containsKey(str)) {
            return (b) f139666g.get(str);
        }
        b d16 = d(b(str));
        f139666g.put(str, d16);
        return d16;
    }
}

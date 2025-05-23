package com.tencent.biz.pubaccount.weishi.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i {

    /* renamed from: g, reason: collision with root package name */
    private static volatile i f80585g;

    /* renamed from: b, reason: collision with root package name */
    private String f80587b;

    /* renamed from: c, reason: collision with root package name */
    private stSimpleMetaComment f80588c;

    /* renamed from: d, reason: collision with root package name */
    private stSimpleMetaReply f80589d;

    /* renamed from: f, reason: collision with root package name */
    private int f80591f;

    /* renamed from: e, reason: collision with root package name */
    private String f80590e = "0";

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f80586a = new HashMap();

    i() {
    }

    private String b(stSimpleMetaFeed stsimplemetafeed, stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply) {
        String str;
        String str2;
        String str3 = "";
        if (stsimplemetafeed == null) {
            str = "";
        } else {
            str = stsimplemetafeed.f25129id;
        }
        if (stsimplemetacomment == null) {
            str2 = "";
        } else {
            str2 = stsimplemetacomment.f25128id;
        }
        if (stsimplemetareply != null) {
            str3 = stsimplemetareply.f25131id;
        }
        return c(str, str2, str3);
    }

    private String c(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        } else {
            sb5.append("0");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb5.append("&&");
            sb5.append(str2);
        } else {
            sb5.append("&&");
            sb5.append("0");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb5.append("&&");
            sb5.append(str3);
        } else {
            sb5.append("&&");
            sb5.append("0");
        }
        return sb5.toString();
    }

    public static i g() {
        if (f80585g == null) {
            synchronized (i.class) {
                if (f80585g == null) {
                    f80585g = new i();
                }
            }
        }
        return f80585g;
    }

    private void k(String str, String str2) {
        x.b("WSCommentRestoreManager", "[WSCommentRestoreManager][storeComment] storeKey: " + str + " comment: " + str2);
        this.f80586a.put(str, str2);
    }

    public stSimpleMetaComment d(String str) {
        if (!TextUtils.equals(this.f80587b, str)) {
            this.f80588c = null;
        }
        return this.f80588c;
    }

    public stSimpleMetaReply e(String str) {
        if (!TextUtils.equals(this.f80587b, str)) {
            this.f80589d = null;
        }
        return this.f80589d;
    }

    public String f() {
        if (TextUtils.isEmpty(this.f80587b)) {
            return "0";
        }
        return this.f80587b;
    }

    public int h(stSimpleMetaFeed stsimplemetafeed, stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply) {
        if (!TextUtils.equals(b(stsimplemetafeed, stsimplemetacomment, stsimplemetareply), this.f80590e)) {
            this.f80591f = 0;
            this.f80590e = "0";
        }
        return this.f80591f;
    }

    public String i(stSimpleMetaFeed stsimplemetafeed, stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply) {
        return this.f80586a.remove(b(stsimplemetafeed, stsimplemetacomment, stsimplemetareply));
    }

    public void a() {
        this.f80588c = null;
        this.f80589d = null;
        this.f80587b = "0";
        this.f80591f = 0;
        this.f80590e = "0";
        this.f80586a.clear();
    }

    public void j(stSimpleMetaFeed stsimplemetafeed, stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply, String str, int i3) {
        if (stsimplemetafeed != null) {
            this.f80587b = stsimplemetafeed.f25129id;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f80588c = stsimplemetacomment;
            this.f80589d = stsimplemetareply;
        } else {
            this.f80588c = null;
            this.f80589d = null;
            i(stsimplemetafeed, null, null);
            i3 = 0;
        }
        String b16 = b(stsimplemetafeed, stsimplemetacomment, stsimplemetareply);
        k(b16, str);
        this.f80590e = b16;
        this.f80591f = i3;
    }
}

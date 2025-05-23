package com.tencent.biz.subscribe.utils;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    public static final String f96287b = "i";

    /* renamed from: c, reason: collision with root package name */
    private static i f96288c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f96289a = new HashMap();

    private String a(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        String str;
        String str2;
        String str3 = "";
        if (certifiedAccountMeta$StFeed == null) {
            str = "";
        } else {
            str = certifiedAccountMeta$StFeed.f24925id.get();
        }
        if (certifiedAccountMeta$StComment == null) {
            str2 = "";
        } else {
            str2 = certifiedAccountMeta$StComment.f24924id.get();
        }
        if (certifiedAccountMeta$StReply != null) {
            str3 = certifiedAccountMeta$StReply.f24928id.get();
        }
        return b(str, str2, str3);
    }

    private String b(String str, String str2, String str3) {
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

    public static i d() {
        if (f96288c == null) {
            synchronized (i.class) {
                if (f96288c == null) {
                    f96288c = new i();
                }
            }
        }
        return f96288c;
    }

    private void f(String str, String str2) {
        QLog.d(f96287b, 1, "storeComment storeKey: " + str + " comment: " + str2);
        this.f96289a.put(str, str2);
    }

    public String c(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        String a16 = a(certifiedAccountMeta$StFeed, certifiedAccountMeta$StComment, certifiedAccountMeta$StReply);
        if (this.f96289a.containsKey(a16)) {
            QLog.d(f96287b, 1, "getComment storeKey: " + a16 + " preCommentText: " + this.f96289a.get(a16));
            return this.f96289a.get(a16);
        }
        QLog.d(f96287b, 1, "getComment storeKey: " + a16 + " preCommentText doesn't exit");
        return "";
    }

    public void e(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply, String str) {
        f(a(certifiedAccountMeta$StFeed, certifiedAccountMeta$StComment, certifiedAccountMeta$StReply), str);
    }
}

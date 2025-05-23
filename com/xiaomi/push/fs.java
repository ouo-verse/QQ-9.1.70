package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fs {

    /* renamed from: c, reason: collision with root package name */
    private static volatile fs f388927c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f388928a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, ft> f388929b = new HashMap();

    fs(Context context) {
        this.f388928a = context;
    }

    public static fs a(Context context) {
        if (context == null) {
            jz4.c.B("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f388927c == null) {
            synchronized (fs.class) {
                if (f388927c == null) {
                    f388927c = new fs(context);
                }
            }
        }
        return f388927c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft b() {
        ft ftVar = this.f388929b.get("UPLOADER_PUSH_CHANNEL");
        if (ftVar != null) {
            return ftVar;
        }
        ft ftVar2 = this.f388929b.get("UPLOADER_HTTP");
        if (ftVar2 != null) {
            return ftVar2;
        }
        return null;
    }

    Map<String, ft> c() {
        return this.f388929b;
    }

    public void d(ft ftVar, String str) {
        if (ftVar == null) {
            jz4.c.B("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            jz4.c.B("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            c().put(str, ftVar);
        }
    }

    public boolean e(gj gjVar, String str) {
        if (TextUtils.isEmpty(str)) {
            jz4.c.m("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (com.xiaomi.push.service.af.e(gjVar, false)) {
            return false;
        }
        if (TextUtils.isEmpty(gjVar.d())) {
            gjVar.f(com.xiaomi.push.service.af.b());
        }
        gjVar.g(str);
        com.xiaomi.push.service.ba.a(this.f388928a, gjVar);
        return true;
    }
}

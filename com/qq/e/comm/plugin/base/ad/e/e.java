package com.qq.e.comm.plugin.base.ad.e;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.ai;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f38795a;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f38797c;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<String> f38796b = null;

    /* renamed from: d, reason: collision with root package name */
    private final Object f38798d = new Object();

    e() {
    }

    public CopyOnWriteArrayList<String> b() {
        return this.f38796b;
    }

    public static e a() {
        if (f38795a == null) {
            synchronized (e.class) {
                if (f38795a == null) {
                    f38795a = new e();
                }
            }
        }
        return f38795a;
    }

    private void b(String str) {
        CopyOnWriteArrayList<String> b16;
        if (TextUtils.isEmpty(str) || (b16 = b()) == null || b16.contains(str)) {
            return;
        }
        if (b16.size() - 100 >= 0) {
            for (int i3 = 0; i3 <= b16.size() - 100; i3++) {
                b16.remove(0);
            }
        }
        b16.add(str);
    }

    public void a(Context context) {
        if (this.f38797c) {
            return;
        }
        synchronized (e.class) {
            if (this.f38797c) {
                return;
            }
            this.f38797c = true;
            if (context == null) {
                return;
            }
            if (this.f38796b == null) {
                this.f38796b = new CopyOnWriteArrayList<>();
            }
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.e.e.1
                @Override // java.lang.Runnable
                public void run() {
                    File h16 = ai.h();
                    if (h16 != null && h16.exists()) {
                        String c16 = ai.c(h16);
                        if (!TextUtils.isEmpty(c16)) {
                            try {
                                JSONArray jSONArray = new JSONArray(c16);
                                if (jSONArray.length() > 0) {
                                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                        e.this.f38796b.add(jSONArray.get(i3).toString());
                                    }
                                }
                                GDTLogger.i("init from file ids :" + e.this.f38796b.size());
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    private void b(Context context) {
        final CopyOnWriteArrayList<String> b16;
        if (context == null || (b16 = b()) == null || b16.size() <= 0) {
            return;
        }
        GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                JSONArray jSONArray = new JSONArray();
                Iterator it = b16.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put((String) it.next());
                }
                ai.a(ai.h(), jSONArray.toString());
            }
        });
    }

    public boolean a(String str) {
        CopyOnWriteArrayList<String> b16;
        if (!TextUtils.isEmpty(str) && (b16 = b()) != null) {
            Iterator<String> it = b16.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && str.equals(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GDTLogger.d("putExternalReportData id :" + str);
        b(str);
        b(context);
    }
}

package com.tencent.liteav.videobase.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f119385f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static c f119386g;

    /* renamed from: a, reason: collision with root package name */
    final Context f119387a;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f119391e;

    /* renamed from: b, reason: collision with root package name */
    final HashMap<BroadcastReceiver, ArrayList<b>> f119388b = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, ArrayList<b>> f119390d = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<a> f119389c = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Intent f119393a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<b> f119394b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.f119393a = intent;
            this.f119394b = arrayList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f119395a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f119396b;

        /* renamed from: c, reason: collision with root package name */
        boolean f119397c;

        /* renamed from: d, reason: collision with root package name */
        boolean f119398d;

        public final String toString() {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("Receiver{");
            sb5.append(this.f119396b);
            sb5.append(" filter=");
            sb5.append(this.f119395a);
            if (this.f119398d) {
                sb5.append(" DEAD");
            }
            sb5.append("}");
            return sb5.toString();
        }
    }

    c(Context context) {
        this.f119387a = context;
        this.f119391e = new Handler(context.getMainLooper()) { // from class: com.tencent.liteav.videobase.utils.c.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int size;
                a[] aVarArr;
                if (message.what == 1) {
                    c cVar = c.this;
                    while (true) {
                        synchronized (cVar.f119388b) {
                            size = cVar.f119389c.size();
                            if (size <= 0) {
                                return;
                            }
                            aVarArr = new a[size];
                            cVar.f119389c.toArray(aVarArr);
                            cVar.f119389c.clear();
                        }
                        for (int i3 = 0; i3 < size; i3++) {
                            a aVar = aVarArr[i3];
                            int size2 = aVar.f119394b.size();
                            for (int i16 = 0; i16 < size2; i16++) {
                                b bVar = aVar.f119394b.get(i16);
                                if (!bVar.f119398d) {
                                    bVar.f119396b.onReceive(cVar.f119387a, aVar.f119393a);
                                }
                            }
                        }
                    }
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public static c a() {
        c cVar;
        synchronized (f119385f) {
            if (f119386g == null) {
                f119386g = new c(ContextUtils.getApplicationContext());
            }
            cVar = f119386g;
        }
        return cVar;
    }

    public final boolean a(Intent intent) {
        int i3;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.f119388b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f119387a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z16 = (intent.getFlags() & 8) != 0;
            if (z16) {
                LiteavLog.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.f119390d.get(intent.getAction());
            if (arrayList3 != null) {
                if (z16) {
                    LiteavLog.v("LocalBroadcastManager", "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i16 = 0;
                while (i16 < arrayList3.size()) {
                    b bVar = arrayList3.get(i16);
                    if (z16) {
                        LiteavLog.v("LocalBroadcastManager", "Matching against filter " + bVar.f119395a);
                    }
                    if (bVar.f119397c) {
                        if (z16) {
                            LiteavLog.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i3 = i16;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i3 = i16;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = bVar.f119395a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z16) {
                                LiteavLog.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.f119397c = true;
                            i16 = i3 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z16) {
                            LiteavLog.v("LocalBroadcastManager", "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i16 = i3 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i17 = 0; i17 < arrayList5.size(); i17++) {
                        ((b) arrayList5.get(i17)).f119397c = false;
                    }
                    this.f119389c.add(new a(intent, arrayList5));
                    if (!this.f119391e.hasMessages(1)) {
                        this.f119391e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}

package com.tencent.luggage.wxa.wq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public long f144337a;

    /* renamed from: b, reason: collision with root package name */
    public long f144338b;

    /* renamed from: c, reason: collision with root package name */
    public long f144339c;

    /* renamed from: d, reason: collision with root package name */
    public List f144340d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public List f144341e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public List f144342f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public List f144343g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public List f144344h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public List f144345i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public List f144346j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public List f144347k = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f144348a;

        /* renamed from: b, reason: collision with root package name */
        public long f144349b;

        public a(int i3, long j3) {
            this.f144348a = i3;
            this.f144349b = j3;
        }

        public String toString() {
            return "\"" + this.f144348a + "\":" + this.f144349b;
        }
    }

    public void a(long j3) {
        this.f144339c = j3;
    }

    public void b(long j3) {
        this.f144337a = j3;
    }

    public void c(long j3) {
        this.f144338b = j3;
    }

    public void a(int i3, long j3) {
        this.f144340d.add(new a(i3, j3));
    }

    public void a(String str, int i3, long j3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith(XWalkPluginManager.XWALK_PLUGIN_NAME_PDF)) {
            this.f144341e.add(new a(i3, j3));
            return;
        }
        if (str.startsWith(XWalkPluginManager.XWALK_PLUGIN_NAME_WORD)) {
            this.f144342f.add(new a(i3, j3));
            return;
        }
        if (str.startsWith(XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL)) {
            this.f144343g.add(new a(i3, j3));
            return;
        }
        if (str.startsWith(XWalkPluginManager.XWALK_PLUGIN_NAME_PPT)) {
            this.f144344h.add(new a(i3, j3));
            return;
        }
        if (str.startsWith(XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE)) {
            this.f144345i.add(new a(i3, j3));
        } else if (str.startsWith(XWalkPluginManager.XWALK_PLUGIN_NAME_TXT)) {
            this.f144346j.add(new a(i3, j3));
        } else if (str.startsWith(XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)) {
            this.f144347k.add(new a(i3, j3));
        }
    }

    public String a(List list) {
        if (list == null || list.isEmpty()) {
            return "{}";
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).toString());
        }
        return "{" + TextUtils.join(";", arrayList) + "}";
    }

    public void a() {
        String str = XWebSdk.getXWebSdkVersion() + "," + XWebSdk.getAvailableVersion() + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO) + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), XWalkPluginManager.XWALK_PLUGIN_NAME_PDF) + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), XWalkPluginManager.XWALK_PLUGIN_NAME_WORD) + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL) + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), XWalkPluginManager.XWALK_PLUGIN_NAME_PPT) + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE) + "," + a(this.f144340d) + "," + a(this.f144347k) + "," + a(this.f144341e) + "," + a(this.f144342f) + "," + a(this.f144343g) + "," + a(this.f144344h) + "," + a(this.f144345i) + "," + this.f144337a + "," + this.f144338b + "," + this.f144339c + "," + this.f144340d.size() + "," + this.f144347k.size() + "," + this.f144341e.size() + "," + this.f144342f.size() + "," + this.f144343g.size() + "," + this.f144344h.size() + "," + this.f144345i.size();
        x0.d("KVReportForCheckStorage", "report:" + str);
        n0.a(24156, str);
    }
}

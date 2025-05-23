package com.tencent.mobileqq.ar.arengine;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.arengine.ag;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    private ag f198128a;

    /* renamed from: b, reason: collision with root package name */
    long f198129b;

    /* renamed from: c, reason: collision with root package name */
    long f198130c;

    /* renamed from: d, reason: collision with root package name */
    int f198131d;

    /* renamed from: e, reason: collision with root package name */
    Object f198132e = new Object();

    /* renamed from: f, reason: collision with root package name */
    AppInterface f198133f;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ag.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f198134a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f198135b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f198136c;

        a(c cVar, ArrayList arrayList, ArrayList arrayList2) {
            this.f198134a = cVar;
            this.f198135b = arrayList;
            this.f198136c = arrayList2;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ag.b
        public void a(long j3, long j16) {
            c cVar = this.f198134a;
            if (cVar != null) {
                cVar.a(ah.this.c(j3, 0));
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ag.b
        public void b(boolean z16, ag.c cVar) {
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + z16);
            c cVar2 = this.f198134a;
            if (cVar2 != null) {
                cVar2.b(cVar.f198121a, z16);
            }
            if (z16) {
                Iterator it = this.f198135b.iterator();
                while (it.hasNext()) {
                    ag.c cVar3 = (ag.c) it.next();
                    if (cVar3.f198122b.equals(cVar.f198122b)) {
                        if (cVar.f198125e) {
                            try {
                                System.currentTimeMillis();
                                int i3 = cVar.f198121a;
                                if (i3 == 6) {
                                    new File(cVar.f198124d);
                                    ai.c(cVar.f198124d, af.f());
                                } else if (i3 == 7) {
                                    ai.c(cVar.f198124d, af.g(cVar.f198123c));
                                } else {
                                    File file = new File(cVar.f198124d);
                                    String str = cVar.f198124d;
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(file.getParentFile().getAbsolutePath());
                                    String str2 = File.separator;
                                    sb5.append(str2);
                                    sb5.append(cVar.f198123c);
                                    sb5.append(str2);
                                    ai.c(str, sb5.toString());
                                }
                                QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
                            } catch (Exception unused) {
                                new File(cVar.f198124d).delete();
                                QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
                                c cVar4 = this.f198134a;
                                if (cVar4 != null) {
                                    cVar4.d(false);
                                }
                                ah.this.d();
                                QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
                                return;
                            }
                        }
                        this.f198136c.remove(cVar3);
                        QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + cVar3.f198122b);
                    }
                }
                if (this.f198136c.size() == 0) {
                    c cVar5 = this.f198134a;
                    if (cVar5 != null) {
                        cVar5.d(true);
                    }
                    ah.this.d();
                    return;
                }
                return;
            }
            c cVar6 = this.f198134a;
            if (cVar6 != null) {
                cVar6.d(false);
            }
            ah.this.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements com.tencent.biz.common.offline.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f198138d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f198139e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ag.c f198140f;

        b(c cVar, ArrayList arrayList, ag.c cVar2) {
            this.f198138d = cVar;
            this.f198139e = arrayList;
            this.f198140f = cVar2;
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline package finish, code = " + i3 + "param1" + str);
            if (i3 == 0) {
                if (str == null) {
                    if (this.f198138d != null) {
                        this.f198139e.remove(this.f198140f);
                        if (this.f198139e.size() == 0) {
                            this.f198138d.d(true);
                            this.f198138d.b(4, true);
                            ah.this.d();
                            return;
                        }
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("data")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        if (jSONArray.length() != 0) {
                            jSONArray.getJSONObject(0).has("bid");
                        }
                        if (this.f198138d != null) {
                            this.f198139e.remove(this.f198140f);
                            if (this.f198139e.size() == 0) {
                                this.f198138d.d(true);
                                this.f198138d.b(4, true);
                                ah.this.d();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    c cVar = this.f198138d;
                    if (cVar != null) {
                        cVar.d(false);
                        this.f198138d.b(4, false);
                        ah.this.d();
                        return;
                    }
                    return;
                }
            }
            if (i3 == 7) {
                if (this.f198138d != null) {
                    this.f198139e.remove(this.f198140f);
                    if (this.f198139e.size() == 0) {
                        this.f198138d.d(true);
                        this.f198138d.b(4, true);
                        ah.this.d();
                        return;
                    }
                    return;
                }
                return;
            }
            c cVar2 = this.f198138d;
            if (cVar2 != null) {
                cVar2.d(false);
                this.f198138d.b(4, false);
                ah.this.d();
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline progress  = " + i3);
            c cVar = this.f198138d;
            if (cVar != null) {
                cVar.a(ah.this.c(0L, i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
        void a(int i3);

        void b(int i3, boolean z16);

        void c();

        void d(boolean z16);
    }

    public ah(AppInterface appInterface) {
        this.f198133f = appInterface;
        this.f198128a = new ag(appInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(long j3, int i3) {
        this.f198129b = Math.max(j3, this.f198129b);
        int max = Math.max(i3, this.f198131d);
        this.f198131d = max;
        long j16 = this.f198130c;
        if (j16 == 0) {
            return max;
        }
        return Math.max((int) ((j3 * 100) / j16), max);
    }

    public void b() {
        synchronized (this.f198132e) {
            d();
        }
    }

    public void d() {
        ag agVar = this.f198128a;
        if (agVar != null) {
            agVar.c();
        }
    }

    public void e(ArrayList<ag.c> arrayList, c cVar) {
        QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad");
        this.f198130c = 0L;
        this.f198129b = 0L;
        this.f198131d = 0;
        if (arrayList.size() < 1) {
            return;
        }
        Iterator<ag.c> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f198130c = Math.max(this.f198130c, it.next().f198127g);
        }
        if (cVar != null) {
            cVar.c();
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad size is " + arrayList2.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3).f198121a != 4) {
                this.f198128a.d(arrayList.get(i3), new a(cVar, arrayList, arrayList2));
            } else if (arrayList.get(i3).f198121a == 4) {
                HtmlOffline.D();
                HtmlOffline.i(arrayList.get(i3).f198122b, this.f198133f, new b(cVar, arrayList2, arrayList.get(i3)), true, 0, true);
            }
        }
    }

    public void f() {
        ag agVar = this.f198128a;
        if (agVar != null) {
            agVar.e();
        }
    }
}

package com.tencent.biz.videostory.entrancewidget;

import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.config.am;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    private static volatile b f97096g;

    /* renamed from: a, reason: collision with root package name */
    private mf0.b f97097a;

    /* renamed from: b, reason: collision with root package name */
    private mf0.c f97098b;

    /* renamed from: c, reason: collision with root package name */
    private mf0.b f97099c;

    /* renamed from: d, reason: collision with root package name */
    private mf0.c f97100d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, c> f97101e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, d> f97102f = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f97109a;

        /* renamed from: b, reason: collision with root package name */
        public String f97110b;

        /* renamed from: c, reason: collision with root package name */
        public String f97111c;

        /* renamed from: d, reason: collision with root package name */
        public String f97112d;

        /* renamed from: e, reason: collision with root package name */
        public String f97113e;

        /* renamed from: f, reason: collision with root package name */
        public String f97114f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f97115g = "";

        public c(String str, JSONObject jSONObject) {
            this.f97110b = "";
            this.f97111c = "";
            this.f97112d = "";
            this.f97113e = "";
            this.f97109a = str;
            try {
                this.f97110b = jSONObject.getString("title");
                this.f97111c = jSONObject.getString("title_color");
                this.f97112d = jSONObject.getString(LayoutAttrDefine.BG_Color);
                this.f97113e = jSONObject.getString("bg_border_color");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }

        public void a(String str) {
            String str2 = str + "/" + this.f97109a;
            File file = new File(str2);
            if (file.exists()) {
                List asList = Arrays.asList(file.list());
                if (asList.contains("take_video@2x.png")) {
                    String str3 = str2 + "/take_video@2x.png";
                    if (new File(str3).exists()) {
                        this.f97114f = str3;
                    }
                }
                if (asList.contains("take_video_no_bg@2x.png")) {
                    String str4 = str2 + "/take_video_no_bg@2x.png";
                    if (new File(str4).exists()) {
                        this.f97115g = str4;
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public String f97117a;

        /* renamed from: b, reason: collision with root package name */
        public String f97118b;

        /* renamed from: c, reason: collision with root package name */
        public String f97119c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f97120d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f97121e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f97122f = "";

        /* renamed from: g, reason: collision with root package name */
        private boolean f97123g;

        public d(String str, String str2) {
            this.f97117a = str;
            this.f97118b = str2;
        }

        public void a(String str) {
            File file = new File(str);
            if (file.exists()) {
                this.f97123g = true;
                List asList = Arrays.asList(file.list());
                if (asList.contains("bg@2x.png")) {
                    String str2 = str + "/bg@2x.png";
                    if (new File(str2).exists()) {
                        this.f97119c = str2;
                    } else {
                        this.f97123g = false;
                    }
                }
                if (asList.contains("camera@2x.png")) {
                    String str3 = str + "/camera@2x.png";
                    if (new File(str3).exists()) {
                        this.f97120d = str3;
                    } else {
                        this.f97123g = false;
                    }
                }
                if (asList.contains("point@2x.png")) {
                    String str4 = str + "/point@2x.png";
                    if (new File(str4).exists()) {
                        this.f97121e = str4;
                    } else {
                        this.f97123g = false;
                    }
                }
            }
        }

        public boolean b() {
            QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isResourceReady:" + this.f97123g);
            return this.f97123g;
        }
    }

    public static synchronized b c() {
        b bVar;
        synchronized (b.class) {
            if (f97096g == null) {
                synchronized (b.class) {
                    if (f97096g == null) {
                        f97096g = new b();
                    }
                }
            }
            bVar = f97096g;
        }
        return bVar;
    }

    private void e() {
        f(this.f97099c);
        g(this.f97100d);
    }

    private void f(mf0.b bVar) {
        QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
        if (bVar != null) {
            String b16 = bVar.b();
            if (TextUtils.isEmpty(b16)) {
                QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
            } else if (com.tencent.biz.videostory.entrancewidget.a.e().h(b16)) {
                h(bVar, com.tencent.biz.videostory.entrancewidget.a.e().d(b16));
            } else {
                com.tencent.biz.videostory.entrancewidget.a.e().c(bVar.b(), new a(bVar, b16));
            }
        }
    }

    private void g(mf0.c cVar) {
        QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
        if (cVar != null) {
            String a16 = cVar.a();
            if (TextUtils.isEmpty(a16)) {
                QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
            } else if (com.tencent.biz.videostory.entrancewidget.a.e().h(a16)) {
                i(cVar, com.tencent.biz.videostory.entrancewidget.a.e().d(a16));
            } else {
                com.tencent.biz.videostory.entrancewidget.a.e().c(cVar.a(), new C0988b(cVar, a16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(mf0.b bVar, String str) {
        QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + str);
        Iterator keys = bVar.a().keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            c cVar = new c(str2, bVar.a().optJSONObject(str2));
            cVar.a(str);
            this.f97101e.put(str2, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(mf0.c cVar, String str) {
        String str2;
        QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initWidgetConfigCache() path:" + str);
        File file = new File(str);
        if (file.exists()) {
            List<String> asList = Arrays.asList(file.list());
            if (asList.contains("widget@2x.png")) {
                str2 = str + "/widget@2x.png";
            } else {
                str2 = "";
            }
            for (String str3 : asList) {
                if (!"widget@2x.png".equals(str3)) {
                    d dVar = new d(str3, cVar.b());
                    dVar.a(str + "/" + str3);
                    dVar.f97122f = str2;
                    this.f97102f.put(str3, dVar);
                } else {
                    return;
                }
            }
        }
    }

    private boolean j() {
        if (MobileQQ.sProcessId == 2) {
            return true;
        }
        return false;
    }

    public d d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f97102f.get(str);
    }

    public void k() {
        try {
            String str = (String) VSConfigManager.c().e("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
            if (!TextUtils.isEmpty(str)) {
                mf0.b d16 = mf0.b.d(str);
                this.f97097a = d16;
                if (d16 != null) {
                    QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.f97097a.toString());
                }
            }
            String str2 = (String) VSConfigManager.c().e("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
            if (!TextUtils.isEmpty(str2)) {
                mf0.c d17 = mf0.c.d(str2);
                this.f97098b = d17;
                if (d17 != null) {
                    QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.f97098b.toString());
                }
            }
            mf0.b bVar = (mf0.b) am.s().x(LpReportInfoConfig.ACTION_TYPE_DIY);
            this.f97099c = bVar;
            if (bVar != null) {
                QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.f97099c.toString());
            }
            mf0.c cVar = (mf0.c) am.s().x(474);
            this.f97100d = cVar;
            if (cVar != null) {
                QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.f97100d.toString());
            }
            if (j()) {
                mf0.b bVar2 = this.f97097a;
                if (bVar2 != null) {
                    this.f97099c = bVar2;
                }
                mf0.c cVar2 = this.f97098b;
                if (cVar2 != null) {
                    this.f97100d = cVar2;
                }
            }
            e();
        } catch (Exception e16) {
            QZLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "loadConfig error!" + e16.toString());
        }
    }

    public boolean l() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ mf0.b f97103a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f97104b;

        a(mf0.b bVar, String str) {
            this.f97103a = bVar;
            this.f97104b = str;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            b.this.h(this.f97103a, com.tencent.biz.videostory.entrancewidget.a.e().d(this.f97104b));
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.videostory.entrancewidget.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0988b implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ mf0.c f97106a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f97107b;

        C0988b(mf0.c cVar, String str) {
            this.f97106a = cVar;
            this.f97107b = str;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            b.this.i(this.f97106a, com.tencent.biz.videostory.entrancewidget.a.e().d(this.f97107b));
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }
}

package com.tencent.ams.mosaic.jsengine.common.download;

import com.tencent.ams.dsdk.utils.DBHelper;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.QuickJSEngine;
import com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
public class a implements IDownloadManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final QuickJSEngine f70870a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.jsengine.common.download.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0688a implements IMosaicDownloadManager.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f70871a;

        C0688a(JSONObject jSONObject) {
            this.f70871a = jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) jSONObject);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            JSONObject jSONObject = this.f70871a;
            if (jSONObject != null) {
                return jSONObject.optString("md5");
            }
            return null;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            JSONObject jSONObject = this.f70871a;
            if (jSONObject != null) {
                return jSONObject.optString(DBHelper.COL_FOLDER);
            }
            return null;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            JSONObject jSONObject = this.f70871a;
            if (jSONObject != null) {
                return jSONObject.optString(QFSEdgeItem.KEY_EXTEND);
            }
            return null;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            JSONObject jSONObject = this.f70871a;
            if (jSONObject != null) {
                return jSONObject.optString("name");
            }
            return null;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String getUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            JSONObject jSONObject = this.f70871a;
            if (jSONObject != null) {
                return jSONObject.optString("url");
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class b implements IMosaicDownloadManager.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final QuickJSEngine f70873a;

        /* renamed from: b, reason: collision with root package name */
        private final JSFunction f70874b;

        /* renamed from: c, reason: collision with root package name */
        private final JSFunction f70875c;

        /* renamed from: d, reason: collision with root package name */
        private final JSFunction f70876d;

        public b(QuickJSEngine quickJSEngine, JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, quickJSEngine, jSFunction, jSFunction2, jSFunction3);
                return;
            }
            this.f70873a = quickJSEngine;
            this.f70874b = jSFunction;
            this.f70875c = jSFunction2;
            this.f70876d = jSFunction3;
        }

        private void c(@IMosaicDownloadManager.ErrorCode int i3, String str) {
            JSFunction jSFunction;
            f.e("DownloadManager", "notifyDownloadFinish, errorCode: " + i3 + ", path: " + str);
            QuickJSEngine quickJSEngine = this.f70873a;
            if (quickJSEngine != null && (jSFunction = this.f70875c) != null) {
                quickJSEngine.u(jSFunction, new Object[]{Integer.valueOf(i3), str}, null);
            }
        }

        private void d() {
            JSFunction jSFunction;
            f.e("DownloadManager", "notifyDownloadStart");
            QuickJSEngine quickJSEngine = this.f70873a;
            if (quickJSEngine != null && (jSFunction = this.f70874b) != null) {
                quickJSEngine.u(jSFunction, null, null);
            }
        }

        private void e(int i3, int i16) {
            JSFunction jSFunction;
            f.a("DownloadManager", "notifyDownloadUpdate, total: " + i3 + ", current: " + i16);
            QuickJSEngine quickJSEngine = this.f70873a;
            if (quickJSEngine != null && (jSFunction = this.f70876d) != null) {
                quickJSEngine.u(jSFunction, new Object[]{Integer.valueOf(i3), Integer.valueOf(i16)}, null);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                c(0, str);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                e(i3, i16);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadPause() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadResume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                d();
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                c(i3, null);
            }
        }
    }

    public a(QuickJSEngine quickJSEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) quickJSEngine);
        } else {
            this.f70870a = quickJSEngine;
        }
    }

    private IMosaicDownloadManager.b a(JSObject jSObject) {
        JSONObject jSONObject;
        QuickJSEngine quickJSEngine = this.f70870a;
        JSONObject jSONObject2 = null;
        if (quickJSEngine == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(e.f(quickJSEngine.l(), jSObject));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            f.e("DownloadManager", "convertDownloadRequest, request: " + jSONObject);
        } catch (Throwable th6) {
            th = th6;
            jSONObject2 = jSONObject;
            f.c("DownloadManager", "create requestObject error.", th);
            jSONObject = jSONObject2;
            return new C0688a(jSONObject);
        }
        return new C0688a(jSONObject);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IDownloadManager
    public IDownload download(JSObject jSObject, JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IDownload) iPatchRedirector.redirect((short) 2, this, jSObject, jSFunction, jSFunction2, jSFunction3);
        }
        f.e("DownloadManager", "download");
        IMosaicDownloadManager f16 = com.tencent.ams.mosaic.f.k().f(this.f70870a);
        if (f16 == null) {
            f.h("DownloadManager", "can't support download manager.");
            QuickJSEngine quickJSEngine = this.f70870a;
            if (quickJSEngine != null && jSFunction2 != null) {
                quickJSEngine.u(jSFunction2, new Object[]{7, null}, null);
            }
            return null;
        }
        IDownload download = f16.download(a(jSObject), new b(this.f70870a, jSFunction, jSFunction2, jSFunction3));
        if (download != null) {
            download.start();
        }
        return download;
    }
}

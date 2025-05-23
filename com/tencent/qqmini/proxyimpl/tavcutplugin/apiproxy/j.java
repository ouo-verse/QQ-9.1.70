package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.i;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0002\u0011\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/j;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/a;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i;", "exporter", "Lnu3/d;", "eventBean", "", "u", "v", "w", HippyTKDListViewAdapter.X, "t", "Lnu3/c;", "f", "p", "<init>", "()V", "a", "b", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j extends a {
    private final void t(i exporter) {
        exporter.f();
        m();
    }

    private final void u(i exporter, nu3.d eventBean) throws JSONException {
        Object f16 = eventBean.f("cutSession");
        if (!(f16 instanceof e)) {
            j("cutSession");
        } else {
            exporter.i((e) f16);
            m();
        }
    }

    private final void v(i exporter, nu3.d eventBean) throws JSONException {
        JSONObject param = eventBean.getParam();
        Integer valueOf = param != null ? Integer.valueOf(param.getInt("videoBitRate")) : null;
        if (valueOf == null) {
            i("param videoBitRate parse error");
        } else {
            exporter.k(valueOf.intValue());
            m();
        }
    }

    private final void w(i exporter, nu3.d eventBean) throws JSONException {
        JSONObject param = eventBean.getParam();
        JSONObject jSONObject = param != null ? param.getJSONObject(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE) : null;
        if (jSONObject == null) {
            i("param videoSize parse error");
        } else {
            exporter.l(com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.o(jSONObject));
            m();
        }
    }

    private final void x(i exporter) throws JSONException {
        IMiniAppFileManager iMiniAppFileManager = getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_FILE_MANAGER java.lang.String();
        String tmpPath = iMiniAppFileManager != null ? iMiniAppFileManager.getTmpPath(".mp4") : null;
        exporter.j(new b(this, exporter));
        if (tmpPath == null) {
            i("generate temperate file path failed");
        } else {
            exporter.g(tmpPath);
            m();
        }
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    public void f(nu3.c eventBean) throws JSONException {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        super.f(eventBean);
        k(new i());
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    public void p(nu3.d eventBean) throws JSONException {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        super.p(eventBean);
        Object targetObj = eventBean.getTargetObj();
        if (!(targetObj instanceof i)) {
            i("invoke func failed, target object 'tavExporter' cannot be found in object pool");
            return;
        }
        String methodName = eventBean.getMethodName();
        if (methodName != null) {
            switch (methodName.hashCode()) {
                case -2008084460:
                    if (methodName.equals("setVideoBitRate")) {
                        v((i) targetObj, eventBean);
                        return;
                    }
                    return;
                case -1422662438:
                    if (methodName.equals("setVideoSize")) {
                        w((i) targetObj, eventBean);
                        return;
                    }
                    return;
                case 1134817270:
                    if (methodName.equals("setCutSession")) {
                        u((i) targetObj, eventBean);
                        return;
                    }
                    return;
                case 2031645366:
                    if (methodName.equals("startExport")) {
                        x((i) targetObj);
                        return;
                    }
                    return;
                case 2078665422:
                    if (methodName.equals("cancelExport")) {
                        t((i) targetObj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/j$b;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i$b;", "", AdMetricTag.EVENT_NAME, "resultKey", "", "resultValue", "", "b", "onExportStart", "", "progress", "onExporting", "exportPath", "onExportCompleted", "", "errCode", "", "throwable", "a", "onExportCancel", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i;", "exporter", "<init>", "(Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/j;Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/i;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class b implements i.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final i exporter;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f347968b;

        public b(j jVar, i exporter) {
            Intrinsics.checkNotNullParameter(exporter, "exporter");
            this.f347968b = jVar;
            this.exporter = exporter;
        }

        private final void b(String eventName, String resultKey, Object resultValue) {
            try {
                this.f347968b.g("tav_export", com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.d(this.exporter, eventName, resultKey, resultValue));
            } catch (JSONException e16) {
                ee4.b.c(this.f347968b.getTAG(), "trySubscribe: ", e16);
            }
        }

        @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.i.b
        public void a(int errCode, Throwable throwable) {
            ee4.b.a(this.f347968b.getTAG(), "onExportError() called with: assetExportSession = [" + errCode + "]");
            if (throwable == null) {
                throwable = new Throwable("exported failed, error code - " + errCode);
            }
            b("failed", "error", throwable);
        }

        @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.i.b
        public void onExportCancel() {
            ee4.b.a(this.f347968b.getTAG(), "onExportCancel() called");
        }

        @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.i.b
        public void onExportCompleted(String exportPath) {
            ee4.b.a(this.f347968b.getTAG(), "onExportCompleted() called with: exportPath = [" + exportPath + "]");
            IMiniAppFileManager iMiniAppFileManager = this.f347968b.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_FILE_MANAGER java.lang.String();
            String wxFilePath = iMiniAppFileManager != null ? iMiniAppFileManager.getWxFilePath(exportPath) : null;
            if (wxFilePath == null) {
                b("failed", "error", new Throwable("wxFilePath is null"));
            } else {
                b("success", "outputURL", wxFilePath);
            }
        }

        @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.i.b
        public void onExporting(float progress) {
            ee4.b.a(this.f347968b.getTAG(), "onExporting() called with: progress = [" + progress + "]");
            b("progress", "progress", Float.valueOf(progress));
        }

        @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.i.b
        public void onExportStart() {
        }
    }
}

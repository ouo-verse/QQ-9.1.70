package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import android.app.Activity;
import android.graphics.PointF;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.g;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.LightAssetModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/g;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/a;", "", HippyTKDListViewAdapter.X, "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/e;", "tavCutSession", "y", "Lnu3/d;", "eventBean", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "Lorg/json/JSONObject;", "param", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", "G", BdhLogUtil.LogTag.Tag_Conn, "w", UserInfo.SEX_FEMALE, "B", "Lnu3/c;", "f", "p", "<init>", "()V", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends a {
    private final void A(nu3.d eventBean, e tavCutSession) {
        JSONObject param = eventBean.getParam();
        if (param == null) {
            i("Event param is null");
            return;
        }
        String z16 = z(param);
        LightAssetModel m3 = tavCutSession.m(z16);
        com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b bVar = com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a;
        o(bVar.a(tavCutSession.c(z16), bVar.c(m3)));
    }

    private final void B(nu3.d eventBean, e tavCutSession) {
        JSONObject param = eventBean.getParam();
        if (param != null) {
            com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b bVar = com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a;
            JSONObject jSONObject = param.getJSONObject("player");
            Intrinsics.checkNotNullExpressionValue(jSONObject, "it.getJSONObject(WSTavCo\u2026tants.JSConstants.PLAYER)");
            Object b16 = bVar.b(jSONObject);
            if (b16 instanceof o) {
                tavCutSession.n((o) b16);
                m();
            }
            h();
        }
        h();
    }

    private final void C(e tavCutSession) {
        tavCutSession.q();
        m();
    }

    private final void D(nu3.d eventBean, e tavCutSession) {
        ArrayList<ClipSource> arrayList;
        JSONObject param = eventBean.getParam();
        if (param == null) {
            i("Event param is null");
            return;
        }
        String z16 = z(param);
        if (z16.length() == 0) {
            i("Template path empty");
            return;
        }
        IMiniAppContext appContext = getAppContext();
        if ((appContext != null ? appContext.getContext() : null) == null) {
            i("Context is null");
            return;
        }
        ee4.b.a(getTAG(), "[setLightTemplate] templatePath=" + z16);
        com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b bVar = com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a;
        c k3 = bVar.k(param);
        if (k3 == null || (arrayList = k3.b()) == null) {
            arrayList = new ArrayList<>();
        }
        if (tavCutSession.r(z16, arrayList, bVar.i(param.getJSONObject("music"), getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_FILE_MANAGER java.lang.String()), bVar.h(param.getJSONArray("fontList"), getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_FILE_MANAGER java.lang.String()))) {
            m();
        } else {
            i("Create renderModel error");
        }
    }

    private final void E(nu3.d eventBean, e tavCutSession) {
        ArrayList<ClipSource> arrayList;
        JSONObject param = eventBean.getParam();
        if (param == null) {
            i("Event param is null");
            return;
        }
        c k3 = com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.k(param);
        if (k3 == null || (arrayList = k3.b()) == null) {
            arrayList = new ArrayList<>();
        }
        if (tavCutSession.s(arrayList)) {
            m();
        } else {
            i("Create renderModel error");
        }
    }

    private final void F(nu3.d eventBean, e tavCutSession) {
        JSONObject param = eventBean.getParam();
        if (param != null) {
            com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b bVar = com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a;
            JSONObject jSONObject = param.getJSONObject("timeRange");
            Intrinsics.checkNotNullExpressionValue(jSONObject, "it.getJSONObject(WSTavCo\u2026s.JSConstants.TIME_RANGE)");
            tavCutSession.t(bVar.m(jSONObject));
            m();
        }
        h();
    }

    private final void G(nu3.d eventBean, e tavCutSession) {
        JSONObject param = eventBean.getParam();
        if (param != null) {
            IMiniAppFileManager iMiniAppFileManager = getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_FILE_MANAGER java.lang.String();
            String absolutePath = iMiniAppFileManager != null ? iMiniAppFileManager.getAbsolutePath(param.getString("filePath")) : null;
            if (absolutePath == null) {
                absolutePath = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(absolutePath, "fileManager?.getAbsolute\u2026nstants.FILE_PATH)) ?: \"\"");
            }
            String str = absolutePath;
            String text = param.getString("text");
            com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b bVar = com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a;
            JSONObject jSONObject = param.getJSONObject("timeRange");
            Intrinsics.checkNotNullExpressionValue(jSONObject, "it.getJSONObject(WSTavCo\u2026s.JSConstants.TIME_RANGE)");
            CMTimeRange m3 = bVar.m(jSONObject);
            JSONObject param2 = eventBean.getParam();
            PointF n3 = bVar.n(param2 != null ? param2.getJSONObject("position") : null);
            JSONObject param3 = eventBean.getParam();
            double d16 = param3 != null ? param3.getDouble("scale") : 1.0d;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            tavCutSession.b(str, m3, text, d16, n3);
        }
        m();
    }

    private final void u(nu3.d eventBean, final e tavCutSession) {
        ee4.b.a(getTAG(), "[downloadLightAbility]");
        JSONObject param = eventBean.getParam();
        if (param == null) {
            i("Event param is null");
            return;
        }
        IMiniAppContext appContext = getAppContext();
        if ((appContext != null ? appContext.getContext() : null) == null) {
            i("Context is null");
            return;
        }
        IMiniAppContext appContext2 = getAppContext();
        Activity attachActivity = appContext2 != null ? appContext2.getAttachActivity() : null;
        final List<String> g16 = com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.g(param);
        ee4.b.a(getTAG(), "[downloadLightAbility] start download");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.f
            @Override // java.lang.Runnable
            public final void run() {
                g.v(e.this, g16);
            }
        }, 128, new b(attachActivity, this), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(e tavCutSession, List bundleList) {
        Intrinsics.checkNotNullParameter(tavCutSession, "$tavCutSession");
        Intrinsics.checkNotNullParameter(bundleList, "$bundleList");
        tavCutSession.d(bundleList);
    }

    private final void w(e tavCutSession) {
        tavCutSession.e();
        m();
    }

    private final void x() {
        k(new e());
    }

    private final void y(e tavCutSession) {
        o(new JSONObject().put("duration", com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.e(CMTime.fromUs(tavCutSession.g()))));
    }

    private final String z(JSONObject param) {
        IMiniAppFileManager iMiniAppFileManager = getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_FILE_MANAGER java.lang.String();
        String absolutePath = iMiniAppFileManager != null ? iMiniAppFileManager.getAbsolutePath(com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.j(param)) : null;
        return absolutePath == null ? "" : absolutePath;
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    public void f(nu3.c eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        super.f(eventBean);
        x();
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    public void p(nu3.d eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        super.p(eventBean);
        Object targetObj = eventBean.getTargetObj();
        if (!(targetObj instanceof e)) {
            ee4.b.a(getTAG(), "[sendMsgInvoke] targetObj=" + targetObj + " is not TavCutSession");
            return;
        }
        String methodName = eventBean.getMethodName();
        if (methodName != null) {
            String methodName2 = eventBean.getMethodName();
            if (methodName2 != null) {
                switch (methodName2.hashCode()) {
                    case -1992012396:
                        if (methodName2.equals("duration")) {
                            y((e) targetObj);
                            return;
                        }
                        break;
                    case -1637817380:
                        if (methodName2.equals("downloadLightAbility")) {
                            u(eventBean, (e) targetObj);
                            return;
                        }
                        break;
                    case -443682845:
                        if (methodName2.equals("setResources")) {
                            E(eventBean, (e) targetObj);
                            return;
                        }
                        break;
                    case 97532676:
                        if (methodName2.equals(HippyQQPagView.FunctionName.FLUSH)) {
                            w((e) targetObj);
                            return;
                        }
                        break;
                    case 558568046:
                        if (methodName2.equals("setLightTemplate")) {
                            D(eventBean, (e) targetObj);
                            return;
                        }
                        break;
                    case 1267320209:
                        if (methodName2.equals("rebindNewPlayer")) {
                            B(eventBean, (e) targetObj);
                            return;
                        }
                        break;
                    case 1325963810:
                        if (methodName2.equals("setWatermark")) {
                            G(eventBean, (e) targetObj);
                            return;
                        }
                        break;
                    case 1563484206:
                        if (methodName2.equals("setTimeRange")) {
                            F(eventBean, (e) targetObj);
                            return;
                        }
                        break;
                    case 1898177600:
                        if (methodName2.equals("removeWatermark")) {
                            C((e) targetObj);
                            return;
                        }
                        break;
                    case 2112503741:
                        if (methodName2.equals("parseLightTemplate")) {
                            A(eventBean, (e) targetObj);
                            return;
                        }
                        break;
                }
            }
            ee4.b.a(getTAG(), "[sendMsgInvoke] not matched method=" + methodName);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/g$b", "Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;", "", "onAdded", "onPreRun", "onPostRun", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ThreadExcutor.IThreadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f347954d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f347955e;

        b(Activity activity, g gVar) {
            this.f347954d = activity;
            this.f347955e = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(g this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.m();
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPostRun() {
            Activity activity = this.f347954d;
            if (activity != null) {
                final g gVar = this.f347955e;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.b.b(g.this);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onAdded() {
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPreRun() {
        }
    }
}

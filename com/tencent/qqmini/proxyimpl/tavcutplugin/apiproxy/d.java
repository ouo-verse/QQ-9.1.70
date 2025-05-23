package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/d;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/a;", "Lnu3/c;", "eventBean", "", "t", "f", "<init>", "()V", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d extends a {
    private final void t(nu3.c eventBean) {
        String str;
        c cVar = new c();
        JSONObject param = eventBean.getParam();
        if (param != null) {
            JSONArray jSONArray = param.getJSONArray("resourceList");
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    IMiniAppFileManager iMiniAppFileManager = getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_FILE_MANAGER java.lang.String();
                    if (iMiniAppFileManager != null) {
                        String string = jSONObject.getString("filePath");
                        if (string == null) {
                            string = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(string, "resourceJsonObj.getStrin\u2026onstants.FILE_PATH) ?: \"\"");
                        }
                        str = iMiniAppFileManager.getAbsolutePath(string);
                    } else {
                        str = null;
                    }
                    String type = jSONObject.getString("type");
                    ee4.b.a(getTAG(), "[generateClipResourceList] filePath=" + str + "  type=" + type);
                    boolean z16 = true;
                    if (!(str == null || str.length() == 0)) {
                        if (type != null && type.length() != 0) {
                            z16 = false;
                        }
                        if (!z16) {
                            Intrinsics.checkNotNullExpressionValue(type, "type");
                            cVar.a(type, str);
                        }
                    }
                }
            } else {
                k(cVar);
                return;
            }
        }
        k(cVar);
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    public void f(nu3.c eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        super.f(eventBean);
        t(eventBean);
    }
}

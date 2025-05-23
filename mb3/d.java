package mb3;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo;
import com.tencent.qphone.base.util.QLog;
import ib3.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0012"}, d2 = {"Lmb3/d;", "", "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "wxaInfo", "", "d", "c", "", "", h.F, "action", "Landroid/os/Bundle;", "params", "", "callbackId", "e", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f416525a = new d();

    d() {
    }

    private final void c(WxaInfo wxaInfo) {
        if (TextUtils.isEmpty(wxaInfo.getWxAppId())) {
            QLog.i("[wxa-q]WxaServerHandler", 1, "dtHideReport wxAppId is empty!");
            return;
        }
        Map<String, String> h16 = h(wxaInfo);
        a.WxaRecord wxaRecord = ib3.a.a().get(wxaInfo.getWxAppId());
        if (wxaRecord != null) {
            h16.put("duration", String.valueOf(System.currentTimeMillis() - wxaRecord.getTimestamp()));
        }
        if (Intrinsics.areEqual(ib3.a.b().get(wxaInfo.getWxAppId()), Boolean.TRUE)) {
            h16.put("applet_hide_type", "1");
        } else {
            h16.put("applet_hide_type", "2");
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonReport("ev_applet_hide", "", h16, null);
        Map<String, Boolean> b16 = ib3.a.b();
        String wxAppId = wxaInfo.getWxAppId();
        Intrinsics.checkNotNull(wxAppId);
        b16.put(wxAppId, Boolean.FALSE);
        QLog.d("[wxa-q]WxaServerHandler", 1, "dtHideReport dtReport duration:" + h16.get("duration") + " hideType:" + h16.get("applet_hide_type"));
        if (QLog.isColorLevel()) {
            QLog.d("[wxa-q]WxaServerHandler", 2, "dtHideReport reportParamsMap:" + h16);
        }
    }

    private final void d(WxaInfo wxaInfo) {
        String str;
        if (TextUtils.isEmpty(wxaInfo.getWxAppId())) {
            QLog.i("[wxa-q]WxaServerHandler", 1, "dtShowReport wxAppId is empty!");
            return;
        }
        Map<String, String> h16 = h(wxaInfo);
        Map<String, Boolean> c16 = ib3.a.c();
        String wxAppId = wxaInfo.getWxAppId();
        Intrinsics.checkNotNull(wxAppId);
        if (Intrinsics.areEqual(c16.get(wxAppId), Boolean.TRUE)) {
            str = "1";
        } else {
            str = "2";
        }
        h16.put("applet_show_type", str);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonReport("ev_applet_show", "", h16, null);
        Map<String, Boolean> c17 = ib3.a.c();
        String wxAppId2 = wxaInfo.getWxAppId();
        Intrinsics.checkNotNull(wxAppId2);
        c17.put(wxAppId2, Boolean.FALSE);
        QLog.i("[wxa-q]WxaServerHandler", 1, "dtShowReport showType:" + str);
        if (QLog.isColorLevel()) {
            QLog.d("[wxa-q]WxaServerHandler", 2, "dtShowReport reportParamsMap:" + h16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(wxaInfo, "$wxaInfo");
        f416525a.d(wxaInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(wxaInfo, "$wxaInfo");
        f416525a.c(wxaInfo);
    }

    private final Map<String, String> h(WxaInfo wxaInfo) {
        String str;
        com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        Object obj = wxaInfo.a().get(StartupReportKey.SCENE_NOTE);
        HashMap hashMap = new HashMap();
        hashMap.put("applet_appid", String.valueOf(wxaInfo.getWxAppId()));
        if (bindingWeChatUserInfo != null) {
            str = bindingWeChatUserInfo.f();
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (null != info) info.openId else \"\"");
        hashMap.put(StartupReportKey.WX_OPENID, str);
        hashMap.put("host_scene", String.valueOf(wxaInfo.getScene()));
        if (obj != null) {
            String str2 = (String) obj;
            hashMap.put(StartupReportKey.SCENE_NOTE, str2);
            QLog.i("[wxa-q]WxaServerHandler", 1, "sceneNoteInfo:" + str2);
        }
        return hashMap;
    }

    public final void e(String action, Bundle params, int callbackId) {
        final WxaInfo wxaInfo;
        if (params != null) {
            params.setClassLoader(WxaInfo.class.getClassLoader());
        }
        if (params == null || (wxaInfo = (WxaInfo) params.getParcelable("wxaInfo")) == null) {
            return;
        }
        QLog.d("[wxa-q]WxaServerHandler", 1, action + " wxaInfo:" + wxaInfo);
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode == -165350003) {
                if (action.equals("client_action_on_hide")) {
                    ib3.a.f(wxaInfo);
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: mb3.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.g(WxaInfo.this);
                        }
                    }, 1000L);
                    return;
                }
                return;
            }
            if (hashCode != -165022904) {
                if (hashCode == 1030397903 && action.equals("client_action_on_destroy")) {
                    ib3.a.e(wxaInfo);
                    return;
                }
                return;
            }
            if (action.equals("client_action_on_show")) {
                ib3.a.g(wxaInfo);
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: mb3.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.f(WxaInfo.this);
                    }
                }, 1000L);
            }
        }
    }
}

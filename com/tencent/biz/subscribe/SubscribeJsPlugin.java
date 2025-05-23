package com.tencent.biz.subscribe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.biz.subscribe.utils.j;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.armap.e;
import com.tencent.mobileqq.armap.f;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class SubscribeJsPlugin extends WebViewPlugin implements e {

    /* renamed from: d, reason: collision with root package name */
    private f f95581d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.troop.b f95582e;

    /* loaded from: classes32.dex */
    public class b extends JSONObject {
        public b(String str) throws JSONException {
            super(str);
        }

        @Override // org.json.JSONObject
        public int getInt(String str) throws JSONException {
            if (has(str)) {
                return super.getInt(str);
            }
            return 0;
        }

        @Override // org.json.JSONObject
        public String getString(String str) throws JSONException {
            if (!has(str)) {
                return "";
            }
            return super.getString(str);
        }
    }

    private void parseJsBridge(String str, String[] strArr) throws JSONException {
        WebViewPlugin.b bVar;
        if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL.equals(str)) {
            if (checkArgsValid(strArr)) {
                b bVar2 = new b(strArr[0]);
                QLog.d("WebViewPlugin", 2, bVar2.toString());
                WebViewPlugin.b bVar3 = this.mRuntime;
                if (bVar3 != null && (bVar3.f() instanceof SubscribeHybirdFragment)) {
                    ((SubscribeHybirdFragment) this.mRuntime.f()).Hh(d.a(bVar2.getString("feedid"), bVar2.getString("uin"), bVar2.getInt("type"), bVar2.getInt("width"), bVar2.getInt("height"), Long.valueOf(bVar2.getString("createtime")).longValue()));
                    return;
                }
                WebViewPlugin.b bVar4 = this.mRuntime;
                if (bVar4 == null || bVar4.a() == null) {
                    return;
                }
                d.o(null, d.a(bVar2.getString("feedid"), bVar2.getString("uin"), bVar2.getInt("type"), bVar2.getInt("width"), bVar2.getInt("height"), Long.valueOf(bVar2.getString("createtime")).longValue()));
                return;
            }
            return;
        }
        if ("sharepersonalpage".equals(str)) {
            if (checkArgsValid(strArr)) {
                b bVar5 = new b(strArr[0]);
                WebViewPlugin.b bVar6 = this.mRuntime;
                if (bVar6 == null || !(bVar6.f() instanceof SubscribeHybirdFragment)) {
                    return;
                }
                QLog.d("WebViewPlugin", 2, bVar5.toString());
                ((SubscribeHybirdFragment) this.mRuntime.f()).Mh(bVar5.getString("uin"), bVar5.getString("nickname"), bVar5.getString("icon"), bVar5.getString("desc"), bVar5.getString("usertype"));
                return;
            }
            return;
        }
        if ("reloadmainpage".equals(str)) {
            WebViewPlugin.b bVar7 = this.mRuntime;
            if (bVar7 == null || !(bVar7.f() instanceof SubscribeHybirdFragment)) {
                return;
            }
            ((SubscribeHybirdFragment) this.mRuntime.f()).Jh();
            return;
        }
        if ("openpublishpage".equals(str)) {
            if (!checkArgsValid(strArr) || (bVar = this.mRuntime) == null || bVar.f() == null) {
                return;
            }
            new Intent().putExtra("postUin", new b(strArr[0]).optString(IPublicAccountBrowser.KEY_PUB_UIN));
            QZoneHelper.forwardToQQPublicAccountPublishPage(this.mRuntime.f().getHostActivity(), null, 0);
            return;
        }
        if ("attachGoods".equals(str)) {
            if (checkArgsValid(strArr)) {
                u(strArr[0]);
                return;
            }
            return;
        }
        if ("cancelfollow".equals(str)) {
            if (checkArgsValid(strArr)) {
                v(strArr[0]);
                return;
            }
            return;
        }
        if ("getavatar".equals(str)) {
            if (checkArgsValid(strArr)) {
                w(strArr[0]);
                return;
            }
            return;
        }
        if ("refreshreturnpage".equals(str)) {
            WebViewPlugin.b bVar8 = this.mRuntime;
            if (bVar8 == null || !(bVar8.f() instanceof SubscribeHybirdFragment)) {
                return;
            }
            ((SubscribeHybirdFragment) this.mRuntime.f()).Ih();
            return;
        }
        if ("getlbslocation".equals(str)) {
            if (checkArgsValid(strArr)) {
                x(strArr[0]);
            }
        } else if ("openhomepage".equals(str) && checkArgsValid(strArr)) {
            d.u(null, new b(strArr[0]).optString("uid"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final String str, final Bitmap bitmap) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.subscribe.SubscribeJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 == null) {
                    return;
                }
                try {
                    String d16 = SubscribeUtils.d(bitmap2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("uin", str);
                    jSONObject.put("avatarData", d16);
                    SubscribeJsPlugin.this.dispatchJsEvent("getAvatarCallback", jSONObject, null);
                } catch (JSONException e16) {
                    QLog.d("WebViewPlugin", 2, e16, new Object[0]);
                }
            }
        }, 8, null, false);
    }

    private void u(String str) throws JSONException {
        JSONArray jSONArray = new b(str).getJSONArray("goods");
        if (jSONArray != null) {
            ArrayList<CommodityBean> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    arrayList.add(new CommodityBean(jSONObject));
                }
            }
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar == null || !(bVar.f() instanceof SubscribeHybirdFragment)) {
                return;
            }
            ((SubscribeHybirdFragment) this.mRuntime.f()).Lh(arrayList);
        }
    }

    private void v(String str) throws JSONException {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.f() == null || this.mRuntime.f().getHostActivity() == null) {
            return;
        }
        b bVar2 = new b(str);
        String optString = bVar2.optString("uin");
        String optString2 = bVar2.optString("nick");
        j.e(this.mRuntime.f().getHostActivity(), optString, optString2, new a(bVar2.optString("callback"), optString2));
    }

    private void w(String str) throws JSONException {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.f() == null || this.mRuntime.f().getHostActivity() == null) {
            return;
        }
        b bVar2 = new b(str);
        final JSONArray optJSONArray = bVar2.optJSONArray("accountList");
        int i3 = "1".equals(bVar2.getString("avatarType")) ? 4 : 1;
        f fVar = this.f95581d;
        if (fVar == null) {
            f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.mRuntime.a(), i3);
            this.f95581d = nonMainAppHeadLoader;
            nonMainAppHeadLoader.init();
            this.f95581d.a(this);
        } else {
            fVar.c(i3);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.subscribe.SubscribeJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                if (optJSONArray != null) {
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        try {
                            String string = optJSONArray.getJSONObject(i16).getString("uin");
                            Bitmap d16 = SubscribeJsPlugin.this.f95581d.d(string, true, null);
                            QLog.i("WebViewPlugin", 4, "handleGetAvatar  uin: " + string);
                            SubscribeJsPlugin.this.t(string, d16);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        }, 16, null, false);
    }

    private void x(String str) throws JSONException {
        b bVar = new b(str);
        Bundle bundle = new Bundle();
        bundle.putString("code", bVar.optString("code"));
        bundle.putString("location", bVar.optString("location"));
        if (this.f95582e == null) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.f95582e = A;
            A.p();
        }
        this.f95582e.M0(bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "qsubscribe";
    }

    @Override // com.tencent.mobileqq.armap.e
    public void h(String str, String str2, Bitmap bitmap) {
        t(str, bitmap);
        if (QLog.isColorLevel()) {
            QLog.i("WebViewPlugin", 4, "handleGetAvatar onFaceUpdate uin: " + str + " -- " + str2 + " head:" + bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("qsubscribe".equals(str2)) {
            QLog.i("WebViewPlugin", 2, "handleJsRequest:" + str);
            try {
                parseJsBridge(str3, strArr);
                return true;
            } catch (JSONException e16) {
                QLog.d("WebViewPlugin", 2, e16, new Object[0]);
                return true;
            }
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.troop.b bVar = this.f95582e;
        if (bVar != null) {
            bVar.q();
            this.f95582e = null;
        }
        f fVar = this.f95581d;
        if (fVar != null) {
            fVar.destroy();
            this.f95581d = null;
        }
    }

    private boolean checkArgsValid(String[] strArr) {
        if (strArr != null && strArr.length >= 1) {
            return true;
        }
        QLog.e("WebViewPlugin", 2, "args is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements j.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f95586a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f95587b;

        a(String str, String str2) {
            this.f95586a = str;
            this.f95587b = str2;
        }

        @Override // com.tencent.biz.subscribe.utils.j.f
        public void a(boolean z16, String str, boolean z17) {
            if (!z17) {
                SubscribeJsPlugin.this.callJs(this.f95586a, "{\"result\":0}");
                if (SubscribeJsPlugin.this.f95582e == null) {
                    SubscribeJsPlugin.this.f95582e = com.tencent.biz.troop.b.A();
                    SubscribeJsPlugin.this.f95582e.p();
                }
                SubscribeJsPlugin.this.f95582e.L0(str, this.f95587b);
                VSReporter.n(str, "auth_follow", "clk_unfollow", 0, 0, "", "", this.f95587b);
                return;
            }
            VSReporter.n(str, "auth_follow", "clk_cancel", 0, 0, "", "", this.f95587b);
        }
    }
}

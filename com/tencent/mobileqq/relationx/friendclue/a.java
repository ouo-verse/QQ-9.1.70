package com.tencent.mobileqq.relationx.friendclue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private Context f280731d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f280732e;

    private Context getCurrentContext() {
        Activity a16 = this.mRuntime.a();
        return (a16 == null || !(a16 instanceof BasePluginActivity)) ? a16 : ((BasePluginActivity) a16).getOutActivity();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "recallFriend";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("recallFriend".equals(str2)) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("ClueApiPlugin", 2, String.format("handleJsRequest method=%s args=%s", str3, strArr[0]));
                }
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("opType");
                if ("move_to_newgroup".equals(optString)) {
                    r(jSONObject.optString("uin"));
                } else if ("remark_edit".equals(optString)) {
                    p(jSONObject.optString("uin"));
                } else if ("common_group".equals(optString)) {
                    q(jSONObject.optString("uin"));
                }
            } catch (Exception e16) {
                QLog.e("ClueApiPlugin", 1, "handleJsRequest fail.", e16);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f280731d = getCurrentContext();
        this.f280732e = this.mRuntime.b();
    }

    void p(String str) {
        EIPCClient client = QIPCClientHelper.getInstance().getClient();
        Bundle bundle = new Bundle();
        bundle.putString("cur_friend_uin", str);
        BinderMethodProxy.callServer(client, "CommonModule", "jumpToRemarkEdit", bundle);
    }

    void q(String str) {
        EIPCClient client = QIPCClientHelper.getInstance().getClient();
        Bundle bundle = new Bundle();
        bundle.putString("cur_friend_uin", str);
        BinderMethodProxy.callServer(client, "CommonModule", "jumpToCommonGroup", bundle);
    }

    void r(String str) {
        startActivityForResult(new Intent(this.f280731d, (Class<?>) MoveToGroupActivity.class).putExtra("friendUin", new AllInOne(str, 1).uin), (byte) 0);
    }
}
